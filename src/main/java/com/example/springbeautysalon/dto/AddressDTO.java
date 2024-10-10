package com.example.springbeautysalon.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AddressDTO {

    private int id;
    @NotNull
    private String street;
    @NotNull
    private String city;

    List<WorkerDTO> workerDTOList;
}
