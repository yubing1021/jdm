package com.sinaif.servicesmst2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceSmsT2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSmsT2Application.class, args);
	}
}
