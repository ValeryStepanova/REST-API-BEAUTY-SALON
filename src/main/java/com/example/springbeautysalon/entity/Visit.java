package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Table
@Entity
@ToString(exclude = "worker")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private double price;

    @Column
    private Timestamp time;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "client_id")
    private Client client;

}
