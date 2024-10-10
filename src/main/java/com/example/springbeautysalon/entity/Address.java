package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table
@ToString(exclude = "workerSet")
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor

@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotNull
    private String street;
    @Column
    @NotNull
    private String city;
    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    Set<Worker> workerSet = new HashSet<>();

}
