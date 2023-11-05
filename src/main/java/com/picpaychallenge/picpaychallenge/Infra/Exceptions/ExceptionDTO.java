package com.picpaychallenge.picpaychallenge.Infra.Exceptions;

public class ExceptionDTO {
    
    public String message;

    public String statusCode;

    public ExceptionDTO (String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
