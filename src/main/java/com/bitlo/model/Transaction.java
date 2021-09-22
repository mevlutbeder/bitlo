package com.bitlo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "transaction")
@NoArgsConstructor
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();

    @Column(name = "status")
    private String status;

    public Transaction(BigDecimal amount, TransactionType type, Wallet wallet, Currency currency, Long senderId, Long receiverId, String status) {
        this.amount = amount;
        this.type = type;
        this.wallet = wallet;
        this.currency = currency;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.status = status;
    }
}
