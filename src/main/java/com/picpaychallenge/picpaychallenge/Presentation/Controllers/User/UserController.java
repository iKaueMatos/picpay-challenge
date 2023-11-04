package com.picpaychallenge.picpaychallenge.Presentation.Controllers.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;
import com.picpaychallenge.picpaychallenge.Application.UseCases.User.UserUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/user")
public class UserController {
    
    private UserUseCase userUseCase;

    @PostMapping("/criar")
    public ResponseEntity<String> create(@Valid @RequestBody UserDTO userDTO) {
        try {
            userUseCase.execute(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Candidato criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar candidato: " + e.getMessage());
        }
    }
}
