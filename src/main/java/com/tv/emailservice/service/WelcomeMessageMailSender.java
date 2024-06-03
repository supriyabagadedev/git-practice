package com.tv.emailservice.service;

import com.tv.emailservice.dto.MailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WelcomeMessageMailSender implements MailSender {
    @Override
    public void sendMail(MailRequest request) {
        log.info("To: " + request.to() + "\nSubject: Welcome to new bank" + "\nBody: Dear user, welcome to NEO Bank");
        System.out.println("welcome message");
    }
}
