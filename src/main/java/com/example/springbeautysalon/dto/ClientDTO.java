package com.example.springbeautysalon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private int id;

    private String name;

    private String gmail;

    private UserDTO userDTO;

    private List<VisitDTO> visitDTOList = new ArrayList<>();
}
