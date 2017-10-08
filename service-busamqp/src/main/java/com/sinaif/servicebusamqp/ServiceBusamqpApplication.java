package com.sinaif.servicebusamqp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.ConditionalOnBusEnabled;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@ConditionalOnBusEnabled
public class ServiceBusamqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBusamqpApplication.class, args);
	}

	@Value("${foo}")
	private String foo;

	@RequestMapping("/hi")
	public String hi() {
		return foo;
	}
}
