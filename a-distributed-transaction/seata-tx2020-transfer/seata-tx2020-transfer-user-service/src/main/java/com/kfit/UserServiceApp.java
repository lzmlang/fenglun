package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //启用注册中心客户端，能够访问到eureka注册中心。
@EnableFeignClients
public class UserServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApp.class, args);
	}
}
