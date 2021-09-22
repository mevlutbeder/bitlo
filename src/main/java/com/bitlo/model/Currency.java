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
@Table(name="currency")
@NoArgsConstructor
public class Currency implements Serializable {

    @Id
    @Column(name = "id",nullable = false) //1
    private String id;

    @Column(name = "name",nullable = false) // Eur
    private String name;

    public Currency(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Currency(String id) {
        this.id = id;
    }
}
