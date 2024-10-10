package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "worker")
@ToString
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Visit> visitSet = new HashSet<>();
}
