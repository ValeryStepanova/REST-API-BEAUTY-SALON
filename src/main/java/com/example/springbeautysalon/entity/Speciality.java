package com.example.springbeautysalon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "speciality")
@ToString(exclude = "workerSet")
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "speciality", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Worker> workerSet = new HashSet<>();

}
