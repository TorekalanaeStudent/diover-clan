package com.caneda.fullstack.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data // generates getters, setters, toString, equals, hashCode
@Entity // JPA entity maps to a database table
@Table(name = "CoinFlips") // Name of the table in PostgreSQL
public class CoinFlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userChoice;
    private String outCome;
    private boolean winOrNo;
    private LocalDateTime timeFlippedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
