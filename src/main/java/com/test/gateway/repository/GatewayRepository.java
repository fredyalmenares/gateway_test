package com.test.gateway.repository;

import com.test.gateway.entity.GatewayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<GatewayEntity, String> {

}
