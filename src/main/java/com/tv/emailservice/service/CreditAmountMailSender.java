package com.tv.emailservice.service;

import com.tv.emailservice.dto.MailRequest;
import com.tv.emailservice.exception.AmountNotFoundException;
import com.tv.emailservice.exception.InvalidAmountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditAmountMailSender implements MailSender {
    @Override
    public void sendMail(MailRequest request) {
        String amount = request.body().orElseThrow(() -> new AmountNotFoundException("Amount is required"));
        verifyAmount(amount);
        log.info("To: " + request.to() + "\nSubject: Transaction Alert" + "\n Body: Amount " +
                 amount + " is credited to your account");
    }

    private static void verifyAmount(String amount) {
        if (amount.isEmpty()) {
            throw new InvalidAmountException("Amount cannot be empty");
        }
    }
}
