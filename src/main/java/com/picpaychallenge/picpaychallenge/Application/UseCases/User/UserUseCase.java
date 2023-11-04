package com.picpaychallenge.picpaychallenge.Application.UseCases.User;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;
import com.picpaychallenge.picpaychallenge.Domain.User.Resquest.UserCreationResponse;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserService;
import com.picpaychallenge.picpaychallenge.Domain.User.Services.UserServiceValidation;

public class UserUseCase {
    
    @Autowired
    public UserServiceValidation userServiceValidation;

    @Autowired
    public UserService userService;

    public ResponseEntity<UserCreationResponse> execute(UserDTO userDTO) {
        BigDecimal amountValue = userDTO.getBalance();
    
        if (userServiceValidation != null) {
            UserCreationResponse response = userService.createUser(userDTO);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserCreationResponse(null, "Falha na criação do usuário"));
        }
    }
}
