package com.picpaychallenge.picpaychallenge.Presentation.Controllers.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;
import com.picpaychallenge.picpaychallenge.Application.UseCases.User.UserUseCase;
import com.picpaychallenge.picpaychallenge.Domain.User.Resquest.UserCreationResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/user")
public class UserController {
    
    private UserUseCase userUseCase;

    @PostMapping("/criar")
    public ResponseEntity<UserCreationResponse> create(@Valid @RequestBody UserDTO userDTO) {
        return userUseCase.execute(userDTO);
    }
}
