package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClientService {
    ClientDTO createOrUpdateClient(ClientDTO clientDTO);

    boolean deleteClient(int id);

    ClientDTO findById(Long id);

    List<ClientDTO> findAll();

    Page<ClientDTO> findForPage(int pageNumber, String sortField, String sortDir, String keyword);

}
