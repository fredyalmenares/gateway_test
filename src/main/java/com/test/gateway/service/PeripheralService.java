package com.test.gateway.service;

import com.test.gateway.entity.PeripheralEntity;
import com.test.gateway.repository.PeripheralRepository;
import com.test.gateway.request.CreatePeripheralRequest;
import com.test.gateway.request.UpdatePeripheralRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PeripheralService {

    private final PeripheralRepository peripheralRepository;

    public PeripheralService(PeripheralRepository peripheralRepository) {
        this.peripheralRepository = peripheralRepository;
    }

    public PeripheralEntity findPeripheralBySerialOrFail(Long uid){
        //TODO
        return null;
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
