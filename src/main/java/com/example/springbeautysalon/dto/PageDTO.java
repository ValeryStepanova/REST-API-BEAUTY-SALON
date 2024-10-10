package com.example.springbeautysalon.dto;

import com.example.springbeautysalon.entity.Address;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageDTO {

    private int pageNumber;

    private long totalPages;

    private List<Address> list;

    private List<Long> pageNumbers;
}
