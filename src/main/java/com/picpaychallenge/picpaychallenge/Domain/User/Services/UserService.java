package com.picpaychallenge.picpaychallenge.Domain.User.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;
import com.picpaychallenge.picpaychallenge.Domain.User.Model.UserModelMappers;
import com.picpaychallenge.picpaychallenge.Domain.User.Resquest.UserCreationResponse;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;
import com.picpaychallenge.picpaychallenge.Persistence.Respository.UserRespository;

@Service
public class UserService {
    
    @Autowired
    private UserRespository userRespository;

    private UserModelMappers userModelMappers;

    public UsersEntity findByUserId(Long id) throws Exception {
        return this.userRespository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public UserCreationResponse createUser(UserDTO userDTO) {
        UsersEntity userEntity = userModelMappers.toUsersEntityResponse(userDTO);
        UsersEntity savedUser = this.userRespository.save(userEntity);
        UserDTO userResponse = userModelMappers.toUserDTOResponse(savedUser);

         String responseMessage = "Usuário criado com sucesso";

        return new UserCreationResponse(userResponse, responseMessage);
    }
}
