package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.SpecialityDTO;
import com.example.springbeautysalon.entity.Speciality;
import com.example.springbeautysalon.mappers.SpecialityMapper;
import com.example.springbeautysalon.repositories.SpecialityRepository;
import com.example.springbeautysalon.repositories.WorkerRepository;
import com.example.springbeautysalon.service.SpecialityService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.ENTITY_DOESN_T_EXIST;
import static com.example.springbeautysalon.utils.Constants.ENTITY_IS_EXISTS;

public class SpecialityServiceImpl implements SpecialityService {
    private final Logger LOGGER = Logger.getLogger(SpecialityServiceImpl.class.getName());

    private final SpecialityRepository specialityRepository;
    private final WorkerRepository workerRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository, WorkerRepository workerRepository) {
        this.specialityRepository = specialityRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public SpecialityDTO saveOrUpdate(SpecialityDTO specialityDTO) {
        if (!specialityRepository.existsByName(specialityDTO.getName())) {
            LOGGER.log(Level.INFO, ENTITY_IS_EXISTS);
            return null;
        }
        specialityRepository.save(SpecialityMapper.SPECIALITY_MAPPER.toEntity(specialityDTO));
        return SpecialityMapper.SPECIALITY_MAPPER.toDTO(specialityRepository.findByName(specialityDTO.getName()));
    }

    @Override
    public int delete(int id) {
       if(!specialityRepository.existsById((long) id)){
           LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
           return 0;
       }
       workerRepository.deleteWorkerBySpecialityId(id);
       //if we delete worker we also need to delete visit with worker
       specialityRepository.deleteById((long) id);
       return id;
    }

    @Override
    public SpecialityDTO findById(int id) {
        if(!specialityRepository.existsById((long) id)){
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return null;
        }
        return SpecialityMapper.SPECIALITY_MAPPER.toDTO(specialityRepository.findById((long) id).get());
    }

    @Override
    public List<SpecialityDTO> findAll() {
      List<SpecialityDTO> specialityDTOS = new ArrayList<>();
      List<Speciality> specialities = specialityRepository.findAll();
        for (Speciality s: specialities
             ) {
            specialityDTOS.add(SpecialityMapper.SPECIALITY_MAPPER.toDTO(s));
        }
        return specialityDTOS;
    }
}
