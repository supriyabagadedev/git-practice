package com.tv.emailservice.service;

import com.tv.emailservice.dto.RequestType;
import com.tv.emailservice.exception.InvalidNotifierException;
import org.springframework.stereotype.Service;

import static com.tv.emailservice.constant.ExceptionMessageConstant.INVALID_NOTIFICATION_TYPE_SPECIFIED;

@Service
public class MailSenderFactory {

    public MailSender getMailSender(RequestType requestType) throws InvalidNotifierException {
        switch (requestType) {
            case OTP -> {
                return new OTPMailSender();
            }
            case WELCOME_MAIL -> {
                return new WelcomeMessageMailSender();
            }
            case CREDIT -> {
                return new CreditAmountMailSender();
            }
            case DEBIT -> {
                return new DebitAmountMailSender();
            }
            default -> throw new InvalidNotifierException(INVALID_NOTIFICATION_TYPE_SPECIFIED);
        }
    }
}
