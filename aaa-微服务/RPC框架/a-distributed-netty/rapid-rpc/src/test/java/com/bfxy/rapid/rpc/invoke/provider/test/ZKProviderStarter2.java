package com.bfxy.rapid.rpc.invoke.provider.test;

import com.bfxy.rapid.rpc.config.provider.ProviderConfig;
import com.bfxy.rapid.rpc.config.provider.RpcServerConfig;
import com.bfxy.rapid.rpc.registry.RpcRegistryProviderService;
import com.bfxy.rapid.rpc.zookeeper.CuratorImpl;
import com.bfxy.rapid.rpc.zookeeper.ZookeeperClient;

import java.util.ArrayList;
import java.util.List;

public class ZKProviderStarter2 {

	public static void main(String[] args) {
		
		//	服务端启动
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					ProviderConfig providerConfig = new ProviderConfig();
					providerConfig.setInterface("com.bfxy.rapid.rpc.invoke.consumer.test.HelloService");
					HelloServiceImpl hellpHelloServiceImpl = HelloServiceImpl.class.newInstance();
					providerConfig.setRef(hellpHelloServiceImpl);
					
					List<ProviderConfig> providerConfigs = new ArrayList<ProviderConfig>();
					providerConfigs.add(providerConfig);
					
					ZookeeperClient zookeeperClient = new CuratorImpl("192.168.11.221:2181,192.168.11.222:2181,192.168.11.223:2181", 10000);
					RpcRegistryProviderService registryProviderService = new RpcRegistryProviderService(zookeeperClient);
					RpcServerConfig rpcServerConfig = new RpcServerConfig(providerConfigs, registryProviderService);
					rpcServerConfig.setPort(8766);
					rpcServerConfig.exporter();
					
				} catch(Exception e){
					e.printStackTrace();
				}	
			}
		}).start();
		
	}
}
