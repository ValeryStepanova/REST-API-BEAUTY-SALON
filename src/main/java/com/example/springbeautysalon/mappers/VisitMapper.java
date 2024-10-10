package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.VisitDTO;
import com.example.springbeautysalon.entity.Visit;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface VisitMapper {

    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);
    @Mapping(target = "id")
    Visit toEntity(VisitDTO visitDTO);
    @Mapping(target = "id")
    VisitDTO toDTO(Visit visit);

}
