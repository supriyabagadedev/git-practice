package com.tv.emailservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public record MailRequest(
        Optional<String> body,
        @NotNull(message = "Enter a valid recipient")
        @NotBlank(message = "Enter a valid recipient")
        @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Enter a valid recipient")
        String to
) {
}
