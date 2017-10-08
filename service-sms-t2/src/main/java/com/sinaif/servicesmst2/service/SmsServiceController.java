package com.sinaif.servicesmst2.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SmsServiceController {

    private Logger LOG= LoggerFactory.getLogger(SmsServiceController.class);

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

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

    @RequestMapping("/hi")
    public String home(){
        LOG.info("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info(){
        LOG.info("info is being called");
        return restTemplate.getForObject("http://localhost:8081/info",String.class);
    }
}
