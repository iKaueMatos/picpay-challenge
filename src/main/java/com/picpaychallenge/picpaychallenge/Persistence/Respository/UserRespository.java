package com.picpaychallenge.picpaychallenge.Persistence.Respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;

@Repository
public interface UserRespository extends JpaRepository<UsersEntity, Long> {

    Optional<UsersEntity> findByDocument(String document);

    Optional<UsersEntity> findUserById(Long id);
}