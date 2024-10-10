package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.ProcedureDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface ProcedureService {
    ProcedureDTO saveOrUpdate(@NotNull ProcedureDTO procedureDTO);
    int delete(int id);
    ProcedureDTO findByID(int id);
    List<ProcedureDTO> findAll();
}
