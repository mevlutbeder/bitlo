package com.bitlo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "transaction_type")
@NoArgsConstructor
public class TransactionType implements Serializable {

    @Id
    @Column(name = "id",nullable = false, unique = true) //C D
    private String id;

    @Column(name = "name", nullable = false) //Credit & Debit
    private String name;

    public TransactionType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public TransactionType(String id) {
        this.id = id;
    }
}
