package com.example.springbeautysalon.repositories;

import com.example.springbeautysalon.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    boolean existsAddressById(int id);

    Address findByCityAndStreet(String city, String street);
}
