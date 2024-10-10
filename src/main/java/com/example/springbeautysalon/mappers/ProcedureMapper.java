package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.ProcedureDTO;
import com.example.springbeautysalon.entity.Procedure;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface ProcedureMapper {
    ProcedureMapper INSTANCE = Mappers.getMapper(ProcedureMapper.class);

    @Mapping(target = "id")
    Procedure toEntity(ProcedureDTO procedureDTO);

    @Mapping(target = "id")
    ProcedureDTO toDto(Procedure procedure);
}
