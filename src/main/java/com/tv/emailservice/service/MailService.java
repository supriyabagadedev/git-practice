package com.tv.emailservice.service;

import com.tv.emailservice.dto.MailRequest;
import com.tv.emailservice.dto.RequestType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {
    private final MailSenderFactory mailSenderFactory;

    public MailService(MailSenderFactory mailSenderFactory) {
        this.mailSenderFactory = mailSenderFactory;
    }

    public void sendMail(MailRequest request, RequestType requestType) {
        MailSender mailSender = mailSenderFactory.getMailSender(requestType);
        mailSender.sendMail(request);
        System.out.println("some changes");
    }
}
