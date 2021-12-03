package com.freestack.evaluation.models;

import javax.persistence.*;

@Entity
@Table(name = "uber_driver")
public class UberDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String firstname;

    @Column(length = 255, nullable = false)
    private String lastname;

    private boolean available = true;

    public UberDriver() {}

    public UberDriver(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public UberDriver setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UberDriver setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public UberDriver setAvailable(boolean available) {
        this.available = available;
        return this;
    }
}
