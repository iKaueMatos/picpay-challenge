package com.picpaychallenge.picpaychallenge.Domain.Transactions.Model;

import org.modelmapper.ModelMapper;

import com.picpaychallenge.picpaychallenge.Application.DTO.Transaction.TransactionDTO;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.TransactionsEntity;

public class TransactionsModelMappers {
    
    private ModelMapper mapper;

    public TransactionsEntity toTransactionEntityResponse(TransactionDTO transactionDTO) {
        return mapper.map(transactionDTO, TransactionsEntity.class);
    }

    public TransactionDTO toTransactionDTOResponse(TransactionsEntity TransactionsEntity) {
        return mapper.map(TransactionsEntity, TransactionDTO.class);
    }
}
