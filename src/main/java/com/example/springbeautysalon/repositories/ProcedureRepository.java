package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    boolean existsByNameAndPrice(String name, double price);

    Procedure findMaterialByPriceAndName(double price, String name);

    boolean existsById(int id);
}
