package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {
    private final EmailSenderGatoway emailSenderGatoway;

    @Autowired
    public EmailSenderService(EmailSenderGatoway emailSenderGatoway) {
        this.emailSenderGatoway = emailSenderGatoway;
    }

}
