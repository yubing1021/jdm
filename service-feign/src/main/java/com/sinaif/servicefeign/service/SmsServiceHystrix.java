package com.sinaif.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @Author darben
 * @Date 2017/9/1716:59
 */

@Component
public class SmsServiceHystrix implements SmsService {

    @Override
    public String sendSms(String userMobile) {
        return "sorry,the server failover.";
    }
}
