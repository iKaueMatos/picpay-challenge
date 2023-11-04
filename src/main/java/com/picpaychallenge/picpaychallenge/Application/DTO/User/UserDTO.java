package com.picpaychallenge.picpaychallenge.Application.DTO.User;

import java.math.BigDecimal;

import com.picpaychallenge.picpaychallenge.Domain.User.Enum.UserType;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;
    
    private String lastname;
    
    private String document;
    
    private BigDecimal balance;
    
    private UserType userType;
    
    private String email;
    
    private String password;
}
