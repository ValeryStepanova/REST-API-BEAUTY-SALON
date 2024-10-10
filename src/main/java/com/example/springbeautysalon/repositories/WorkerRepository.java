package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    void deleteWorkerByAddress_Id(int id);
    Worker findByNameAndPrice(String name, double price);

    boolean existsById(int id);
    void deleteWorkerBySpecialityId(int id);
    void deleteWorkerByProcedureId(int id);
}
