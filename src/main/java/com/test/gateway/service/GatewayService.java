package com.test.gateway.service;

import com.test.gateway.entity.GatewayEntity;
import com.test.gateway.repository.GatewayRepository;
import com.test.gateway.request.CreateGatewayRequest;
import com.test.gateway.request.UpdateGatewayRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GatewayService {

    private final GatewayRepository gatewayRepository;
    private final PeripheralService peripheralService;

    public GatewayService(GatewayRepository gatewayRepository, PeripheralService peripheralService) {
        this.gatewayRepository = gatewayRepository;
        this.peripheralService = peripheralService;
    }

    public GatewayEntity findGatewayBySerialOrFail(String serial){
        //TODO
        return null;
    }

    public Collection<GatewayEntity> findAll(){
        //TODO
        return null;
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

    public Collection<GatewayEntity> addPeripheralToGateway(String serial, Long uid){
        //TODO
        return null;
    }

    public Collection<GatewayEntity> removePeripheralFromGateway(String serial, Long uid){
        //TODO
        return null;
    }


}
