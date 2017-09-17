package com.sinaif.servicefeign.webapp;

import com.sinaif.servicefeign.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Description 
 *@Author Darben
 *@Date 2017/9/16 19:42
*/
@RestController
public class SmsServiceController {

    @Autowired
    private SmsService smsService;

    @RequestMapping("/smsSend")
    public String smsSend(@RequestParam String userMobile){
        return smsService.sendSms(userMobile);
    }
}
