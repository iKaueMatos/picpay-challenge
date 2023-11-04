package com.picpaychallenge.picpaychallenge.Domain.User.Model;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.picpaychallenge.picpaychallenge.Application.DTO.User.UserDTO;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;

@Component
public class UserModelMappers {
    
    private ModelMapper mapper;

    public UsersEntity toUsersEntityResponse(UserDTO userDTO) {
        return mapper.map(userDTO, UsersEntity.class);
    }

    public UserDTO toUserDTOResponse(UsersEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }
}
