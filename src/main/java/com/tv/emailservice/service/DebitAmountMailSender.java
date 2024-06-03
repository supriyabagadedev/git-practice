package com.tv.emailservice.service;

import com.tv.emailservice.dto.MailRequest;
import com.tv.emailservice.exception.AmountNotFoundException;
import com.tv.emailservice.exception.InvalidAmountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DebitAmountMailSender implements MailSender {
    @Override
    public void sendMail(MailRequest request) {
        String amount = request.body().orElseThrow(() -> new AmountNotFoundException("Amount is required"));
        verifyAmount(amount);
        log.info("To: " + request.to() + "\nSubject: Transaction Alert" + "\nBody: Amount of Rs. " +
                 amount + " is debited from your account");
    }

    private static void verifyAmount(String amount) {
        if (amount.isEmpty()) {
            throw new InvalidAmountException("Amount cannot be empty");
        }
    }
}
