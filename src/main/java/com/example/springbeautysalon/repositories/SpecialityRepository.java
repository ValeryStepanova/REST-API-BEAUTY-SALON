package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    boolean existsByName(String name);
    Speciality findByName(String name);

}
