package com.example.springbeautysalon.service.Impl;

import com.example.springbeautysalon.dto.WorkerDTO;
import com.example.springbeautysalon.entity.Worker;
import com.example.springbeautysalon.mappers.WorkerMapper;
import com.example.springbeautysalon.repositories.VisitRepository;
import com.example.springbeautysalon.repositories.WorkerRepository;
import com.example.springbeautysalon.service.WorkerService;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.springbeautysalon.utils.Constants.*;

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final VisitRepository visitRepository;
    private final Logger LOGGER = Logger.getLogger(WorkerServiceImpl.class.getName());

    public WorkerServiceImpl(WorkerRepository workerRepository, VisitRepository visitRepository) {
        this.workerRepository = workerRepository;
        this.visitRepository = visitRepository;
    }

    @Override
    public WorkerDTO createWorkerOrUpdate(@NotNull WorkerDTO workerDTO) {
        if (null == workerDTO) {
            LOGGER.log(Level.INFO, ENTITY_NULL);
            return null;
        }
        workerRepository.save(WorkerMapper.INSTANCE.toEntity(workerDTO));
        return WorkerMapper.INSTANCE.toDTO(workerRepository.findByNameAndPrice(workerDTO.getName(), workerDTO.getPrice()));
    }

    @Override
    public int deleteWorker(int id) {
        if (!workerRepository.existsById(id)) {
            LOGGER.log(Level.INFO, ENTITY_IS_EXISTS);
            return 0;
        }
        visitRepository.deleteVisitByWorkerId(id);
        workerRepository.deleteById((long) id);
        return id;
    }


    @Override
    public WorkerDTO findByID(int id) {
        if (workerRepository.existsById(id)) {
            LOGGER.log(Level.INFO,ENTITY_DOESN_T_EXIST);
            return null;
        }
        return WorkerMapper.INSTANCE.toDTO(workerRepository.findById((long) id).get());
    }

    @Override
    public List<WorkerDTO> findAll() {
      List<Worker> workers = workerRepository.findAll();
      List<WorkerDTO> workerDTOS = new ArrayList<>();
        for (Worker worker: workers
             ) {
            workerDTOS.add(WorkerMapper.INSTANCE.toDTO(worker));
        }
        return workerDTOS;
    }
}
