package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.VisitDTO;
import com.example.springbeautysalon.entity.Visit;
import com.example.springbeautysalon.mappers.VisitMapper;
import com.example.springbeautysalon.repositories.VisitRepository;
import com.example.springbeautysalon.service.VisitService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.ENTITY_DOESN_T_EXIST;
import static com.example.springbeautysalon.utils.Constants.ENTITY_IS_EXISTS;

public class VisitServiceImpl implements VisitService {
    private final Logger LOGGER = Logger.getLogger(VisitServiceImpl.class.getName());
    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public VisitDTO createOrUpdate(VisitDTO visitDTO) {
      if(!visitRepository.existsByTimeAndClientIdAndWorkerId(visitDTO.getTimestamp(),
              visitDTO.getClientDTO().getId(), visitDTO.getWorkerDTO().getId())){
        LOGGER.log(Level.INFO, ENTITY_IS_EXISTS);
          return null;
      }
      visitRepository.save(VisitMapper.INSTANCE.toEntity(visitDTO));
      return VisitMapper.INSTANCE.toDTO(visitRepository.findByClientIdAndWorkerIdAndTime(
              visitDTO.getClientDTO().getId(),
              visitDTO.getWorkerDTO().getId(),
              visitDTO.getTimestamp()));
    }

    @Override
    public int delete(int id) {
        if(!visitRepository.existsById((long) id)){
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return 0;
        }
        visitRepository.deleteById((long) id);
        return id;
    }

    @Override
    public VisitDTO findByID(int id) {
        if(!visitRepository.existsById((long) id)){
            LOGGER.log(Level.INFO, ENTITY_DOESN_T_EXIST);
            return null;
        }
        return VisitMapper.INSTANCE.toDTO(visitRepository.findById((long) id).get());
    }

    @Override
    public List<VisitDTO> findAll() {
       List<Visit> visits = visitRepository.findAll();
       List<VisitDTO> visitDTOS = new ArrayList<>();
        for (Visit visit: visits
             ) {
            visitDTOS.add(VisitMapper.INSTANCE.toDTO(visit));
        }
        return visitDTOS;
    }
}
