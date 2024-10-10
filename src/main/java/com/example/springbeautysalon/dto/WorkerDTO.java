package com.example.springbeautysalon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDTO {
    private int id;

    private String name;

    private double price;

    private ProcedureDTO procedureDTO;

    private AddressDTO addressDTO;

    private SpecialityDTO specialityDTO;

    private Set<VisitDTO> visitSet = new HashSet<>();

}
