package com.picpaychallenge.picpaychallenge.Domain.User.Resquest;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;

public class UserCreationResponse {
    
    private UserDTO userDTO;

    private String responseMessage;

    public UserCreationResponse(UserDTO userDTO, String responseMessage) {
        this.userDTO = userDTO;
        this.responseMessage = responseMessage;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
