package com.picpaychallenge.picpaychallenge.Domain.User.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;
import com.picpaychallenge.picpaychallenge.Domain.User.Enum.UserType;

@Service
public class UserServiceValidation {

    public boolean validationTransactionUser(UserDTO sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() != UserType.COMMON) {
            throw new Exception("Usuario do tipo logista não esta autorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuario não tem saldo insuficiente");
        }
        
        return false;
    }
}
