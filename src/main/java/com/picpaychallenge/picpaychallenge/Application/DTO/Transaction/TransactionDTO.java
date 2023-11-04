package com.picpaychallenge.picpaychallenge.Application.DTO.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;

import lombok.Data;

@Data
public class TransactionDTO {
    
    private Long id;

    private String typeTransaction;

    private String numberCard;

    private BigDecimal amount;

    private UsersEntity sender;

    private UsersEntity receiver;

    private LocalDateTime timeSDateTime;
}
