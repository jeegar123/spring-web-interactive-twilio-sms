package com.twillosms.app.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twillosms.app.mode.SMS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${com.twillo.account.sid}")
    private String ACCOUNT_SID;

    @Value("${com.twillo.account.tokken}")
    private String AUTH_TOKEN;

    @Value("${com.twillo.account.phone.number}")
    private String FROM_NUMBER;

    public void send(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
    }
    
}
