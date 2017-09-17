package com.sinaif.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "servicesms",fallback =SmsServiceHystrix.class)
public interface SmsService {

    @RequestMapping(method = RequestMethod.GET, value = "/sendSms")
    String sendSms(@RequestParam(value = "userMobile") String userMobile);

}
