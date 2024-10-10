package com.example.springbeautysalon.service;

import com.example.springbeautysalon.dto.WorkerDTO;

import java.util.List;

public interface WorkerService {
    WorkerDTO createWorkerOrUpdate(WorkerDTO workerDTO);
    int deleteWorker(int id);

    WorkerDTO findByID(int id);
    List<WorkerDTO> findAll();
}
