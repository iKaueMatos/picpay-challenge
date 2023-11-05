package com.picpaychallenge.picpaychallenge.Presentation.Controllers.Transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaychallenge.picpaychallenge.Application.DTO.Transaction.TransactionDTO;
import com.picpaychallenge.picpaychallenge.Application.UseCases.Transaction.TransactionUseCase;

@RestController
@RequestMapping("v1/transaction")
public class TransactionController {
    
    private TransactionUseCase transactionUseCase;

    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) throws Exception {
        return transactionUseCase.execute(transactionDTO);
    }
}
