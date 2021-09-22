package com.bitlo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "wallet")
@NoArgsConstructor
public class Wallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();

    public Wallet(Long user_id, BigDecimal amount, List<Transaction> transactions, Currency currency) {
        this.user_id = user_id;
        this.amount = amount;
        this.transactions = transactions;
        this.currency = currency;
    }

    public Wallet(Long id) {
        this.id = id;
    }
}
