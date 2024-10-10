package com.example.springbeautysalon.mappers;

import com.example.springbeautysalon.dto.AddressDTO;
import com.example.springbeautysalon.entity.Address;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    @Mapping(target = "id")
    Address toEntity(AddressDTO addressDTO);

    @Mapping(target = "id")
    AddressDTO toDTO(Address address);
}
