package com.picpaychallenge.picpaychallenge.Persistence.Entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.br.CPF;

import com.picpaychallenge.picpaychallenge.Domain.User.Enum.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
public class UsersEntity {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "sobrenome")
    private String lastname;

    @CPF
    @Column(name = "cpf", unique = true)
    private String document;

    @Column(name = "saldo")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private UserType userType;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "senha")
    private String password;
}
