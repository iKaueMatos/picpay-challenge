package com.picpaychallenge.picpaychallenge.Persistence.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpaychallenge.picpaychallenge.Persistence.Entity.TransactionsEntity;

public interface TransactionsRespository extends JpaRepository<TransactionsEntity, Long> { }
