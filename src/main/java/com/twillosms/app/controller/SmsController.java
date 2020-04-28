package com.twillosms.app.controller;

import com.twillosms.app.mode.SMS;
import com.twillosms.app.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmsController {

    Logger logger = LoggerFactory.getLogger(SmsController.class);

    final
    SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    public String sendSms(@RequestParam("mobileNumber") String mobileNumber, @RequestParam("message") String message, ModelMap modelMap) {
        SMS sms = new SMS(mobileNumber, message);
        logger.info(sms.toString());
        try {
            logger.info("calling send()");
            smsService.send(sms);
            logger.info("calling send() is done");
            modelMap.addAttribute("msg", "Message Send Successfully");
            logger.info("done");
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            modelMap.addAttribute("msg", "Message is not send");
        }

        return "index";

    }
}
