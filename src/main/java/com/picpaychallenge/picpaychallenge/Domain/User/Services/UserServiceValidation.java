package com.picpaychallenge.picpaychallenge.Domain.User.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.picpaychallenge.picpaychallenge.Domain.User.Enum.UserType;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;

@Service
public class UserServiceValidation {

    public boolean validationTransactionUser(UsersEntity userDTO, BigDecimal amount) throws Exception {
        if (userDTO.getUserType() != UserType.COMMON) {
            throw new Exception("Usuario do tipo logista não esta autorizado a realizar transação");
        }

        if (userDTO.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuario não tem saldo insuficiente");
        }
        
        return false;
    }
}
