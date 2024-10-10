package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.MaterialDTO;
import com.example.springbeautysalon.entity.Material;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface MaterialMapper {
    MaterialMapper MATERIAL_MAPPER = Mappers.getMapper(MaterialMapper.class);

    @Mapping(target = "id")
    Material toEntity(MaterialDTO materialDTO);

    @Mapping(target = "id")
    MaterialDTO toDTO(Material material);
}
