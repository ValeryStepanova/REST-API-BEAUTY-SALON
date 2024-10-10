package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    boolean existsByPriceAndAndName(double price, String name);
    Material findMaterialByPriceAndName(double price, String name);

    boolean existsById(int id);
}
