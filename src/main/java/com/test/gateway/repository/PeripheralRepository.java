package com.test.gateway.repository;

import com.test.gateway.entity.PeripheralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeripheralRepository extends JpaRepository<PeripheralEntity, Long> {
    @Modifying
    @Query(value = "UPDATE peripheral p SET p.gateway_serial = null where p.gateway_serial=:gateway_serial", nativeQuery = true)
    void deleteBooks(@Param("gateway_serial") String gateway_serial);
}
