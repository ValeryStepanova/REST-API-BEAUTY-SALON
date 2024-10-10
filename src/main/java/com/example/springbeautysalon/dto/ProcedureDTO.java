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
public class ProcedureDTO {

    private int id;

    private String name;

    private double price;

    private Set<MaterialDTO> materials = new HashSet<>();

    private Set<WorkerDTO> workerSet = new HashSet<>();
}
