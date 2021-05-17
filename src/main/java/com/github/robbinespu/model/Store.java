package com.github.robbinespu.model;

import javax.persistence.*;

@Entity
@Table(name = "databaseTable")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Store(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Store() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
