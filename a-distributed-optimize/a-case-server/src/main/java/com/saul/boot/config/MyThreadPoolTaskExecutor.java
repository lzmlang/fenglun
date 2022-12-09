package com.saul.boot.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 枫伦
 * @DESCRIPTION 异步任务线程池
 * @create 2021/1/6 9:59 上午
 */
@Configuration("MyThreadPoolTaskExecutor")
@EnableBatchProcessing(modular=true)
public class MyThreadPoolTaskExecutor {
    @Value("${task.pool.corePoolSize}")
    private int corePoolSize;

    @Value("${task.pool.maxPoolSize}")
    private int maxPoolSize;

    @Value("${task.pool.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Value("${task.pool.queueCapacity}")
    private int queueCapacity;

    @Value("${task.pool.threadNamePrefix}")
    private String threadNamePrefix;

    /**
     * 默认异步线程池
     *
     * @return
     */
    @Bean(name = "myTaskExecutor", value = "myTaskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix(threadNamePrefix);//线程名字前缀
        executor.setCorePoolSize(corePoolSize);//核心线程数
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        // 直接在execute方法的调用线程中运行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 初始化
        executor.initialize();
        return executor;
    }
    @Bean(name = "myThreadPoolExecutor", value = "myThreadPoolExecutor")
    public ThreadPoolExecutor myThreadPoolExecutor() {
        ThreadFactory threadFactory = new CustomizableThreadFactory("thread-pull-order-%d");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveSeconds, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(queueCapacity), threadFactory,new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
