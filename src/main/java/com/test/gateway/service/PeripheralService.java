package com.test.gateway.service;

import com.test.gateway.GatewayApplication;
import com.test.gateway.entity.PeripheralEntity;
import com.test.gateway.repository.PeripheralRepository;
import com.test.gateway.request.CreatePeripheralRequest;
import com.test.gateway.request.UpdatePeripheralRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
public class PeripheralService {

    private final PeripheralRepository peripheralRepository;

    public PeripheralService(PeripheralRepository peripheralRepository) {
        this.peripheralRepository = peripheralRepository;
    }

    public PeripheralEntity findPeripheralBySerialOrFail(Long uid){
        return this.peripheralRepository.findById(uid).orElseThrow(() -> new EntityNotFoundException("Peripheral"));
    }

    public PeripheralEntity savePeripheralEntity(PeripheralEntity peripheralEntity){
        return this.peripheralRepository.saveAndFlush(peripheralEntity);
    }

    public Collection<PeripheralEntity> findAll(){
        //TODO
        return null;
    }

    public PeripheralEntity createPeripheral(CreatePeripheralRequest createPeripheralRequest){
        //TODO
        return null;
    }

    public PeripheralEntity updatePeripheral(Long uid, UpdatePeripheralRequest updatePeripheralRequest){
        //TODO
        return null;
    }

    public boolean deletePeripheral(Long uid){
        //TODO
        return true;
    }
}
