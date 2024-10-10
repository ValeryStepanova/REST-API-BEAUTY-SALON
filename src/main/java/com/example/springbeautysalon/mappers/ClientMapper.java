package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.ClientDTO;
import com.example.springbeautysalon.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id")
    Client toEntity(ClientDTO clientDTO);

    @Mapping(target = "id")
    ClientDTO toDTO(Client client);

}
