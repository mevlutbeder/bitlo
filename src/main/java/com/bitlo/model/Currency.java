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
@Table(name = "currency")
@NoArgsConstructor
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_code", nullable = false) // Eur
    private String currencyCode;

    @Column(name = "description") // Eur
    private String description;

    @Column(name = "date_created")
    private LocalDateTime dateCreated = LocalDateTime.now();

    public Currency(String currencyCode, String description) {
        this.currencyCode = currencyCode;
        this.description = description;
    }

    public Currency(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
