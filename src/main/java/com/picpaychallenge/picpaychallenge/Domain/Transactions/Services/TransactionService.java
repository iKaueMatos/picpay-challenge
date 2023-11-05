package com.picpaychallenge.picpaychallenge.Domain.Transactions.Services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.picpaychallenge.picpaychallenge.Application.DTO.Transaction.TransactionDTO;
import com.picpaychallenge.picpaychallenge.Domain.Transactions.Model.TransactionsModelMappers;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserService;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserServiceValidation;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.TransactionsEntity;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;
import com.picpaychallenge.picpaychallenge.Persistence.Respository.TransactionsRespository;

public class TransactionService {
    
    @Autowired
    private UserServiceValidation userServiceValidation;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    private NotificationService notificationService;

    private TransactionsModelMappers transactionsModelMappers;

    private TransactionsRespository transactionsRespository;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) throws Exception {
        long senderId = transactionDTO.getSender().getId();
        long receiverId = transactionDTO.getReceiver().getId();

        BigDecimal amount = transactionDTO.getAmount();
        UsersEntity sender = userService.findByUserId(senderId);
        UsersEntity receiver = userService.findByUserId(receiverId);
        userServiceValidation.validationTransactionUser(sender, amount);

        boolean isAuthorized = this.authorizationTransaction(sender, amount);

        if(!isAuthorized) {
            throw new Exception("Transação não autorizada!");
        }

        TransactionsEntity transactionsEntity = transactionsModelMappers.toTransactionEntityResponse(transactionDTO);
        TransactionsEntity savedTransanction = this.transactionsRespository.save(transactionsEntity);
        TransactionDTO transactionResponse = transactionsModelMappers.toTransactionDTOResponse(savedTransanction);
        
        this.userService.savedUser(sender);
        this.userService.savedUser(receiver);
        this.notificationService.sendNotification(receiver, "Transação realizado com sucesso!");

        return transactionResponse;
    }

    public boolean authorizationTransaction(UsersEntity sender, BigDecimal value) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);
    
        if (authorizationResponse != null) {
            String message = (String) authorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        }
    
        return false;
    }
    
}
