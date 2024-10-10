package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.AddressDTO;
import com.example.springbeautysalon.entity.Address;
import com.example.springbeautysalon.mappers.AddressMapper;
import com.example.springbeautysalon.repositories.AddressRepository;
import com.example.springbeautysalon.repositories.WorkerRepository;
import com.example.springbeautysalon.service.AddressService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.ENTITY_DOESN_T_EXIST;
import static com.example.springbeautysalon.utils.Constants.ENTITY_NULL;

@Service
public class AddressServiceImpl implements AddressService {

    private final Logger LOGGER = Logger.getLogger(AddressServiceImpl.class.getName());

    private final AddressRepository addressRepository;
    private final WorkerRepository workerRepository;

    public AddressServiceImpl(AddressRepository addressRepository, WorkerRepository workerRepository) {
        this.addressRepository = addressRepository;
        this.workerRepository = workerRepository;
    }


    public AddressDTO createOrUpdateAddressDto(@NotNull AddressDTO addressDTO) {
        if (null == addressDTO) {
            LOGGER.log(Level.INFO, ENTITY_NULL);
            return null;
        }
        addressRepository.save(AddressMapper.INSTANCE.toEntity(addressDTO));
        return AddressMapper.INSTANCE.toDTO(addressRepository.findByCityAndStreet(addressDTO.getCity(), addressDTO.getStreet()));
    }

    @Override
    public int deleteAddressDTO(int id) {
        if (!addressRepository.existsAddressById(id)) {
            LOGGER.log(Level.INFO, "Address doesn't exist");
            return 0;
        }
        workerRepository.deleteWorkerByAddress_Id(id);
        addressRepository.deleteById((long) id);
        return id;
    }

    @Override
    public AddressDTO findById(int id) {
        if (!addressRepository.existsAddressById(id)) {
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return null;
        }
        return AddressMapper.INSTANCE.toDTO(addressRepository.findById((long) id).get());
    }

    @Override
    public List<AddressDTO> findAll() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDTO> addressDTOS = new ArrayList<>();
        for (Address address : addresses
        ) {
            addressDTOS.add(AddressMapper.INSTANCE.toDTO(address));
        }
        return addressDTOS;
    }
}
