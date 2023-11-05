package com.picpaychallenge.picpaychallenge.Application.UseCases.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.picpaychallenge.picpaychallenge.Application.DTO.Transaction.TransactionDTO;
import com.picpaychallenge.picpaychallenge.Domain.Transactions.Services.TransactionService;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserServiceValidation;

public class TransactionUseCase {
    
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserServiceValidation userServiceValidation;

    public ResponseEntity<TransactionDTO> execute(TransactionDTO transactionDTO) throws Exception {
         if (userServiceValidation != null) {
            TransactionDTO response = transactionService.createTransaction(transactionDTO);

            return ResponseEntity.ok(response);
        }
        
        return (ResponseEntity<TransactionDTO>) ResponseEntity.badRequest();
    }
}
