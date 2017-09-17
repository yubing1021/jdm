package com.sinaif.serviceribbon.webapp;

import com.sinaif.serviceribbon.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private SmsService smsService;

    @RequestMapping("/smsSend")
    public String smsSend(@RequestParam String userMobile){
        System.out.print("userMobile:"+userMobile);
        return smsService.sendSms(userMobile);
    }

}
