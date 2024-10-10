package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.SpecialityDTO;
import com.example.springbeautysalon.entity.Speciality;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface SpecialityMapper {

    SpecialityMapper SPECIALITY_MAPPER = Mappers.getMapper(SpecialityMapper.class);

    @Mapping(target = "id")
    Speciality toEntity(SpecialityDTO specialityDTO);

    @Mapping(target = "id")
    SpecialityDTO toDTO(Speciality speciality);
}
