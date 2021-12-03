package com.freestack.evaluation.models;

import javax.persistence.*;

@Entity
@Table(name = "uber_user")
public class UberUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String firstname;

    @Column(length = 255, nullable = false)
    private String lastname;

    public UberUser() {}

    public UberUser(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public UberUser setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UberUser setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
