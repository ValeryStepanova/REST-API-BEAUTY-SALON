package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.MaterialDTO;
import com.example.springbeautysalon.entity.Material;
import com.example.springbeautysalon.mappers.MaterialMapper;
import com.example.springbeautysalon.repositories.MaterialRepository;
import com.example.springbeautysalon.service.MaterialService;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.ENTITY_DOESN_T_EXIST;
import static com.example.springbeautysalon.utils.Constants.ENTITY_IS_EXISTS;

public class MaterialServiceImpl implements MaterialService {

    private final Logger LOGGER = Logger.getLogger(MaterialService.class.getName());
    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public MaterialDTO saveOrUpdateMaterial(@NotNull MaterialDTO materialDTO) {
        if (!materialRepository.existsByPriceAndAndName(materialDTO.getPrice(), materialDTO.getName())) {
            LOGGER.log(Level.INFO, ENTITY_IS_EXISTS);
            return null;
        }
        materialRepository.save(MaterialMapper.MATERIAL_MAPPER.toEntity(materialDTO));
        return MaterialMapper.MATERIAL_MAPPER.toDTO(materialRepository.findMaterialByPriceAndName(materialDTO.getPrice(), materialDTO.getName()));
    }

    @Override
    public MaterialDTO findByID(int id) {
        if (!materialRepository.existsById(id)) {
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return null;
        }
        return MaterialMapper.MATERIAL_MAPPER.toDTO(materialRepository.findById((long) id).get());
    }

    @Override
    public int delete(int id) {
        if (materialRepository.existsById(id)) {
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return 0;
        }
        materialRepository.deleteById((long) id);
        return id;
    }

    @Override
    public List<MaterialDTO> findAll() {
        List<Material> materials = materialRepository.findAll();
        List<MaterialDTO> materialDTOS = new ArrayList<>();
        for (Material material : materials
        ) {
            materialDTOS.add(MaterialMapper.MATERIAL_MAPPER.toDTO(material));
        }
        return materialDTOS;
    }
}
