package com.test.gateway.service;

import com.test.gateway.entity.GatewayEntity;
import com.test.gateway.exception.EntityAlreadyExistsException;
import com.test.gateway.exception.GatewayHasPeripheralException;
import com.test.gateway.repository.GatewayRepository;
import com.test.gateway.request.CreateGatewayRequest;
import com.test.gateway.request.UpdateGatewayRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GatewayService {

    private final GatewayRepository gatewayRepository;
    private final PeripheralService peripheralService;

    public GatewayService(GatewayRepository gatewayRepository, @Lazy PeripheralService peripheralService) {
        this.gatewayRepository = gatewayRepository;
        this.peripheralService = peripheralService;
    }

    public GatewayEntity findGatewayBySerialOrFail(String serial) {
        return this.gatewayRepository.findById(serial).orElseThrow(() -> new EntityNotFoundException("Gateway"));
    }

    public List<GatewayEntity> findAll() {
        return this.gatewayRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public GatewayEntity createGateway(CreateGatewayRequest createGatewayRequest) {
        try {
            this.findGatewayBySerialOrFail(createGatewayRequest.getSerial());
            throw new EntityAlreadyExistsException("Gateway", "serial", createGatewayRequest.getSerial());
        } catch (EntityNotFoundException ex) {
            GatewayEntity gatewayEntity = new GatewayEntity();
            gatewayEntity.setSerial(createGatewayRequest.getSerial());
            gatewayEntity.setName(createGatewayRequest.getName());
            gatewayEntity.setAddress(createGatewayRequest.getAddress());
            return this.gatewayRepository.saveAndFlush(gatewayEntity);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public GatewayEntity updateGateway(String serial, UpdateGatewayRequest updateGatewayRequest) {
        GatewayEntity gatewayEntity = this.findGatewayBySerialOrFail(serial);
        gatewayEntity.setName(updateGatewayRequest.getName());
        gatewayEntity.setAddress(updateGatewayRequest.getAddress());
        return this.gatewayRepository.saveAndFlush(gatewayEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteGateway(String serial) {
        GatewayEntity gatewayEntity = this.findGatewayBySerialOrFail(serial);
        if(gatewayEntity.getPeripherals().size() > 0){
            throw new GatewayHasPeripheralException(gatewayEntity.getSerial());
        }
        this.gatewayRepository.deleteById(serial);
    }

    public List<GatewayEntity> addPeripheralToGateway(String serial, Long uid) {
        //TODO
        return null;
    }

    public List<GatewayEntity> removePeripheralFromGateway(String serial, Long uid) {
        //TODO
        return null;
    }


}
