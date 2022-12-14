package com.bfxy.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class NettyHttpServerTest {

	static final int PORT = 8888;
	 
    public static void main(String[] args) throws Exception {
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
      
		DefaultEventExecutorGroup defaultEventExecutorGroup = new DefaultEventExecutorGroup(
                4,
                new ThreadFactory() {
                    private AtomicInteger threadIndex = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "NettyServerWorkerThread_" + this.threadIndex.incrementAndGet());
                    }
                });
		
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.childOption(ChannelOption.TCP_NODELAY,true);
            b.childOption(ChannelOption.SO_KEEPALIVE,true);
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(defaultEventExecutorGroup,
                            		new HttpServerCodec(),
                            		new HttpObjectAggregator(1024*1024),
                            		new HttpServerExpectContinueHandler(),
                            		new NettyHttpServerHandler());
                        }
                    });

            Channel ch = b.bind(PORT).sync().channel();
            System.err.println("Netty http server listening on port "+ PORT);
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    
    public static class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, HttpObject message) throws Exception {
			
			//	???????????????HttpRequest??????
			if (message instanceof HttpRequest){
				HttpRequest request = (HttpRequest)message;
				HttpMethod method = request.method();
				HttpHeaders headers = request.headers();
				
				//	?????????????????? get/post????????????????????????
				if(HttpMethod.GET.equals(method)) {
					System.err.println("doGet ..");
				} 
				else if (HttpMethod.POST.equals(method)) {
					System.err.println("doPost ..");
					//	post????????????fullRequest????????????????????????
					FullHttpRequest fullRequest = (FullHttpRequest)message;
			        String contentType = headers.get(HttpHeaderNames.CONTENT_TYPE);
			        contentTypeConverter(contentType);
				}
				
				sendResponse(ctx, request);
			} else {
				log.error("#NettyHttpServerHandler.channelRead0# message type is not HttpRequest: {}", message);
			}
		}
		
		/**
		 * 	$contentTypeConverter ???????????????contentType ??????????????????????????????
		 * @param contentType
		 */
		private void contentTypeConverter(String contentType) {
			if(StringUtils.isNotBlank(contentType)) {
				//	???????????????????????????????????????contentType??????????????????
				if(HttpHeaderValues.APPLICATION_JSON.toString().equals(contentType)){
		        	System.err.println("contentType is application/json");
		        } else if(HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString().equals(contentType)) {
		        	System.err.println("contentType is application/x-www-form-urlencoded");
		        } 
				// else if ....
			} else {
				log.warn("#NettyHttpServerHandler.channelRead0# message contentType is null, contentType: {}", contentType);
			}
		}
		
		/**
		 * 	$sendResponse ??????????????????
		 * @param ctx
		 * @param request
		 */
		private void sendResponse(ChannelHandlerContext ctx, HttpRequest request) {
			String responseBody = "hello client";
            DefaultFullHttpResponse httpResponse = new DefaultFullHttpResponse(
            		HttpVersion.HTTP_1_1,
            		HttpResponseStatus.OK, 
            		Unpooled.wrappedBuffer(responseBody.getBytes()));
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, httpResponse.content().readableBytes());
            //	??????keepAlive???true????????????????????????????????????
            boolean keepAlive = HttpUtil.isKeepAlive(request);
            if (!keepAlive) {
                ctx.writeAndFlush(httpResponse).addListener(ChannelFutureListener.CLOSE);
            } else {
            	httpResponse.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                ctx.writeAndFlush(httpResponse);
            }
		}
    	
    }
}
