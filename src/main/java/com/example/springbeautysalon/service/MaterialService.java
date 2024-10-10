package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.MaterialDTO;

import java.util.List;

public interface MaterialService {
    MaterialDTO saveOrUpdateMaterial(MaterialDTO materialDTO);

    MaterialDTO findByID(int id);
    int delete(int id);
    List<MaterialDTO> findAll();
}
