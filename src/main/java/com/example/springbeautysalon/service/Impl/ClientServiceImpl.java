package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.ClientDTO;
import com.example.springbeautysalon.entity.Client;
import com.example.springbeautysalon.mappers.ClientMapper;
import com.example.springbeautysalon.repositories.ClientRepository;
import com.example.springbeautysalon.repositories.VisitRepository;
import com.example.springbeautysalon.service.ClientService;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.ENTITY_DOESN_T_EXIST;
import static com.example.springbeautysalon.utils.Constants.ENTITY_IS_EXISTS;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final VisitRepository visitRepository;
    private final Logger LOGGER = Logger.getLogger(ClientServiceImpl.class.getName());

    public ClientServiceImpl(ClientRepository clientRepository, VisitRepository visitRepository) {
        this.clientRepository = clientRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    public ClientDTO createOrUpdateClient(@NotNull ClientDTO clientDTO) {
        if (clientRepository.existsClientByGmail(clientDTO.getGmail())) {
            LOGGER.log(Level.INFO, ENTITY_IS_EXISTS);
            return clientDTO;
        }
        clientRepository.save(ClientMapper.INSTANCE.toEntity(clientDTO));
        return ClientMapper.INSTANCE.toDTO(clientRepository.findClientByGmail(clientDTO.getGmail()));
    }

    @Override
    public boolean deleteClient(int id) {

        if (!clientRepository.existsClientById(id)) {
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return false;
        }
        visitRepository.deleteAllByClient_Id(id);
        clientRepository.deleteById((long) id);
        return true;
    }

    @Override
    public ClientDTO findById(Long id) {
        return Optional.ofNullable(id)
                .flatMap(clientRepository::findById)
                .map(ClientMapper.INSTANCE::toDTO)
                .orElse(null);
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> result = new ArrayList<>();
        for (Client client : clients
        ) {
            result.add(ClientMapper.INSTANCE.toDTO(client));
        }
        return result;
    }

    @Override
    public Page<ClientDTO> findForPage(int pageNumber, String sortField, String sortDir, String keyword) {
        return null;
    }


}
