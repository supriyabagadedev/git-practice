package com.tv.emailservice.controller;


import com.tv.emailservice.dto.MailRequest;
import com.tv.emailservice.dto.RequestType;
import com.tv.emailservice.service.MailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@CrossOrigin
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendMail(@RequestHeader(value = "REQUEST-TYPE") RequestType requestType,
                         @RequestBody @Valid MailRequest request) {
        mailService.sendMail(request, requestType);
        System.out.println("new change");
    }
}
