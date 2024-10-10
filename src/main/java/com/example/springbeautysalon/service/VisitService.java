package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.VisitDTO;
import com.example.springbeautysalon.entity.Visit;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface VisitService {
    VisitDTO createOrUpdate(@NotNull VisitDTO visitDTO);

    int delete(int id);
    VisitDTO findByID(int id);
    List<VisitDTO> findAll();
}
