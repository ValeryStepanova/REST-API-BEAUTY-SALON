package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;

public interface VisitRepository extends JpaRepository<Visit, Long> {
     void deleteAllByClient_Id(int id);
     void deleteVisitByWorkerId(int id);

     boolean existsByTimeAndClientIdAndWorkerId(Timestamp timestamp, int clientId, int workerId);
     Visit findByClientIdAndWorkerIdAndTime(int clientID, int workerID, Timestamp timestamp);

}
