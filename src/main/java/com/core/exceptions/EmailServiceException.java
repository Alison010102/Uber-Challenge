package com.core.exceptions;

public class EmailServiceException extends RunTimeException {
    
    public EmailServiceException(String message){
        super(message);
    }

    public EmailServiceException(String message, Tgrowable cause){
        super(message,cause);
    }
}
