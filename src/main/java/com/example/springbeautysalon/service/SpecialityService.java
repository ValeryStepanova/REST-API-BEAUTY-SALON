package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.SpecialityDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface SpecialityService {
    SpecialityDTO saveOrUpdate(@NotNull SpecialityDTO specialityDTO);

    int delete(int id);

    SpecialityDTO findById(int id);

    List<SpecialityDTO> findAll();
}
