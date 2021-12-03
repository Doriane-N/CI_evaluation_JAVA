package com.freestack.evaluation.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "end_of_the_booking")
    private LocalDateTime endOfTheBooking;

    private int evaluation;

    @Column(name = "start_of_the_booking")
    private LocalDateTime startOfTheBooking;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private UberDriver driver;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UberUser user;

    public Booking() {}

    public Long getId() {
        return id;
    }

    public LocalDateTime getEndOfTheBooking() {
        return endOfTheBooking;
    }

    public Booking setEndOfTheBooking(LocalDateTime endOfTheBooking) {
        this.endOfTheBooking = endOfTheBooking;
        return this;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public Booking setEvaluation(int evaluation) {
        this.evaluation = evaluation;
        return this;
    }

    public LocalDateTime getStartOfTheBooking() {
        return startOfTheBooking;
    }

    public Booking setStartOfTheBooking(LocalDateTime startOfTheBooking) {
        this.startOfTheBooking = startOfTheBooking;
        return this;
    }

    public UberDriver getDriver() {
        return driver;
    }

    public Booking setDriver(UberDriver driver) {
        this.driver = driver;
        return this;
    }

    public UberUser getUser() {
        return user;
    }

    public Booking setUser(UberUser user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", endOfTheBooking=" + endOfTheBooking +
                ", evaluation=" + evaluation +
                ", startOfTheBooking=" + startOfTheBooking +
                ", driver=" + driver.getLastname() +
                ", user=" + user.getLastname() +
                '}';
    }
}
