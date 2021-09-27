package com.bitlo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "transaction_type")
@NoArgsConstructor
public class TransactionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false) //C & D
    private String type;

    @Column(name = "description") //Credit & Debit
    private String description;

    @Column(name = "date_created")
    private LocalDateTime dateCreated = LocalDateTime.now();

    public TransactionType(String type, String description) {
        this.type = type;
        this.description = description;
    }

}
