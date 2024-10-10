package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.ProcedureDTO;
import com.example.springbeautysalon.entity.Procedure;
import com.example.springbeautysalon.mappers.ProcedureMapper;
import com.example.springbeautysalon.repositories.ProcedureRepository;
import com.example.springbeautysalon.repositories.WorkerRepository;
import com.example.springbeautysalon.service.ProcedureService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.ENTITY_DOESN_T_EXIST;
import static com.example.springbeautysalon.utils.Constants.ENTITY_IS_EXISTS;

public class ProcedureServiceImpl implements ProcedureService {
    private Logger LOGGER = Logger.getLogger(ProcedureServiceImpl.class.getName());
    private final ProcedureRepository procedureRepository;
    private final WorkerRepository workerRepository;

    public ProcedureServiceImpl(ProcedureRepository procedureRepository, WorkerRepository workerRepository) {
        this.procedureRepository = procedureRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public ProcedureDTO saveOrUpdate(ProcedureDTO procedureDTO) {
        if(!procedureRepository.existsByNameAndPrice(procedureDTO.getName(), procedureDTO.getPrice())){
            LOGGER.log(Level.INFO, ENTITY_IS_EXISTS);
            return null;
        }
        procedureRepository.save(ProcedureMapper.INSTANCE.toEntity(procedureDTO));
        return ProcedureMapper.INSTANCE.toDto(procedureRepository.findMaterialByPriceAndName(procedureDTO.getPrice(), procedureDTO.getName()));
    }

    @Override
    public int delete(int id) {
       if(!procedureRepository.existsById(id)){
           LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
           return 0;
       }
       workerRepository.deleteWorkerByProcedureId(id);
       procedureRepository.deleteById((long) id);
       return id;
    }

    @Override
    public ProcedureDTO findByID(int id) {
        if(!procedureRepository.existsById(id)){
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return null;
        }
        return ProcedureMapper.INSTANCE.toDto(procedureRepository.findById((long) id).get());
    }

    @Override
    public List<ProcedureDTO> findAll() {
      List<Procedure> procedures = procedureRepository.findAll();
      List<ProcedureDTO> procedureDTOS = new ArrayList<>();
        for (Procedure pr: procedures
             ) {
            procedureDTOS.add(ProcedureMapper.INSTANCE.toDto(pr));
        }
        return procedureDTOS;
    }
}
