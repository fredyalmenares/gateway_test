package com.test.gateway.repository;

import com.test.gateway.entity.PeripheralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeripheralRepository extends JpaRepository<PeripheralEntity, Long> {
   
}
