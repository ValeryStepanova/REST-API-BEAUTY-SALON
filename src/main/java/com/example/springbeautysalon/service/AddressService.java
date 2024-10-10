package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createOrUpdateAddressDto(AddressDTO addressDTO);

    int deleteAddressDTO(int id);

    AddressDTO findById(int id);

    List<AddressDTO> findAll();

}
