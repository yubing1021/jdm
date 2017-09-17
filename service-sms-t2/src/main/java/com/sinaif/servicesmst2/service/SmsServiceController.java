package com.sinaif.servicesmst2.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SmsServiceController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/sendSms")
    public String sendSms(@RequestParam String userMobile){
        if(org.springframework.util.StringUtils.isEmpty(userMobile)){
            return "please check userMobile params."+port;
        }
        else{
            return userMobile+" send sms success."+port;
        }
    }

    @RequestMapping("/receiveSms")
    public String receiveSms(@RequestParam String userMobile){
        if(StringUtils.isEmpty(userMobile)){
            return "please check userMobile params.";
        }
        else{
            return userMobile+" receiveSms content is hello world.";
        }
    }

    @RequestMapping("/sayHello")
    public String sayHello(HttpServletRequest request){
        String t=request.getParameter("t");
        if(StringUtils.isEmpty(t)){
            t="World";
        }
        return "Hello "+t;
    }
}
