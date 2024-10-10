package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {
    boolean existsClientByGmail(String gmail);

   Client findClientByGmail(String gmail);

    boolean existsClientById(int id);

}
