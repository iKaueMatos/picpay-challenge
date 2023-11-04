package com.picpaychallenge.picpaychallenge.Application.UseCases.Transaction;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.picpaychallenge.picpaychallenge.Application.DTO.Transaction.TransactionDTO;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserService;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserServiceValidation;
import com.picpaychallenge.picpaychallenge.Domain.User.Transactions.Services.TransactionService;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;

public class TransactionUseCase {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserServiceValidation userServiceValidation;

    private UserService userService;

    public TransactionDTO execute(TransactionDTO transactionDTO) throws Exception {
        long senderId = transactionDTO.getSender().getId();
        long receiverId = transactionDTO.getReceiver().getId();

        BigDecimal amount = transactionDTO.getAmount();
        UsersEntity sender = userService.findByUserId(senderId);
        UsersEntity receiver = userService.findByUserId(receiverId);
        
        userServiceValidation.validationTransactionUser(sender, amount);

        return transactionDTO;
    }

    // public boolean authorizationTransaction(UsersEntity usersEntity, BigDecimal value) {

    // }
}
