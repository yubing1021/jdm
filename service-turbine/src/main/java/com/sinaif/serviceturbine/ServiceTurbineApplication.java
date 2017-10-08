package com.sinaif.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
//@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
class ServiceTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTurbineApplication.class, args);
	}
}
