package com.tv.emailservice.service;

import com.tv.emailservice.dto.MailRequest;

public interface MailSender {
    void sendMail(MailRequest request);
}
