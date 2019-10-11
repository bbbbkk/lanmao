package com.lanmao.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lanmao.core.share")
public class LanmaoWebBopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanmaoWebBopsApplication.class, args);
	}

}
