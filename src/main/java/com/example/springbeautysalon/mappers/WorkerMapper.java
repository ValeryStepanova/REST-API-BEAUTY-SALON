package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.WorkerDTO;
import com.example.springbeautysalon.entity.Worker;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    @Mapping(target = "id")
    Worker toEntity(WorkerDTO workerDTO);

    @Mapping(target = "id")
    WorkerDTO toDTO(Worker worker);
}
