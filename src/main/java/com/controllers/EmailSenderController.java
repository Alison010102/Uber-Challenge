package com.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.EmailSenderService;
import com.core.EmailRequest;
import com.core.exceptions.EmailServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/email")

public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailService) {
        this.emailSenderService = emailService;
    }
    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{

            this.emailSenderService.sendEmail(request.to(),request.subject(),request.body());
            return ResponseEntity.ok("Email sent successfully");
        }catch(EmailServiceException ex){
            return ResponseEntity.status(500).body("Failed to send email: " + ex.getMessage());
        }
    }

}
