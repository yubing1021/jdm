package com.sinaif.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sendSmsError")
    public String sendSms(String userMobile){
        return restTemplate.getForObject("http://servicesms/sendSms?userMobile="+userMobile, String.class);
    }

    public String sendSmsError(String userMobile){
        return userMobile+" send sms occur error.";
    }
}
