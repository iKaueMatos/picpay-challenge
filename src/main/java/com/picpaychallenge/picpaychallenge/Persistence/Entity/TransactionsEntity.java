package com.picpaychallenge.picpaychallenge.Persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transacoes")
@EqualsAndHashCode(of = "id")
public class TransactionsEntity {
    
    @Id
    @Column(name = "id_transacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_transacao")
    private String typeTransaction;

    @Column(name = "numero_cartao_credito")
    private String numberCard;

    @Column(name = "valor_transacao")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private UsersEntity sender;

    @ManyToOne
    @JoinColumn(name = "receptor_id")
    private UsersEntity receiver;

    @CurrentTimestamp
    @Column(name = "date_created")
    private LocalDateTime timeSDateTime;
}
