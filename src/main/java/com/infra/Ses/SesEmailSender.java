package com.infra.Ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.AmazonServiceException;
import com.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("secundo2002@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try {
            this.amazonSimpleEmailService.sendEmail(request);

        } catch (AmazonServiceException exception) {
            throw new RuntimeException("Failure while sending email", exception);
        }
    }
}