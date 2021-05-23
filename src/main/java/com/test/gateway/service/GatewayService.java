package com.test.gateway.service;

import com.test.gateway.entity.GatewayEntity;
import com.test.gateway.repository.GatewayRepository;
import com.test.gateway.request.CreateGatewayRequest;
import com.test.gateway.request.UpdateGatewayRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GatewayService {

    private final GatewayRepository gatewayRepository;
    private final PeripheralService peripheralService;

    public GatewayService(GatewayRepository gatewayRepository, PeripheralService peripheralService) {
        this.gatewayRepository = gatewayRepository;
        this.peripheralService = peripheralService;
    }

    public GatewayEntity findGatewayBySerialOrFail(String serial){
        return this.gatewayRepository.findById(serial).orElseThrow(() -> new EntityNotFoundException("Gateway"));
    }

    public List<GatewayEntity> findAll(){
        return this.gatewayRepository.findAll();
    }

    public GatewayEntity createGateway(CreateGatewayRequest createGatewayRequest){
        //TODO
        return null;
    }

    public GatewayEntity updateGateway(String serial, UpdateGatewayRequest updateGatewayRequest){
        //TODO
        return null;
    }

    public boolean deleteGateway(String serial){
        //TODO
        return true;
    }

    public List<GatewayEntity> addPeripheralToGateway(String serial, Long uid){
        //TODO
        return null;
    }

    public List<GatewayEntity> removePeripheralFromGateway(String serial, Long uid){
        //TODO
        return null;
    }


}
