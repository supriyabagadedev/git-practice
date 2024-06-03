package com.tv.emailservice.service;

import com.tv.emailservice.dto.MailRequest;
import com.tv.emailservice.exception.InvalidOTPException;
import com.tv.emailservice.exception.OTPNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OTPMailSender implements MailSender {
    @Override
    public void sendMail(MailRequest request) {
        String otp = request.body().orElseThrow(() -> new OTPNotFoundException("OTP is required"));
        verifyOTP(otp);
        log.info("To: " + request.to() + "\nSubject: OTP For Neo bank login" + "\nBody: Your OTP is: " +
                 otp);
    }

    private static void verifyOTP(String otp) {
        if (otp.isEmpty()) {
            throw new InvalidOTPException("OTP cannot be empty");
        }
    }
}
