package com.sinaif.configclientt2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClientT2Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientT2Application.class, args);
	}

	@Value("${foo}")
	private String foo;

	@RequestMapping("/hi")
	public String hi() {
		return foo;
	}
}
