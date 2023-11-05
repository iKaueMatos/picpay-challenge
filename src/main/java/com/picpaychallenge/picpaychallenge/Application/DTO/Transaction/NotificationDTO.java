package com.picpaychallenge.picpaychallenge.Application.DTO.Transaction;

public class NotificationDTO {

    public String email;

    public String message;

    public NotificationDTO(String email, String message) {
        this.email = email;
        this.message = message;
    }
}
