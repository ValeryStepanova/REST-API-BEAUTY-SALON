package com.example.springbeautysalon.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private int id;

    private double price;

    private Timestamp timestamp;

    private WorkerDTO workerDTO;

    private ClientDTO clientDTO;
}
