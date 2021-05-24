package com.test.gateway.service;

import com.test.gateway.entity.PeripheralEntity;
import com.test.gateway.repository.PeripheralRepository;
import com.test.gateway.request.CreatePeripheralRequest;
import com.test.gateway.request.UpdatePeripheralRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PeripheralService {

    private final PeripheralRepository peripheralRepository;

    public PeripheralService(PeripheralRepository peripheralRepository) {
        this.peripheralRepository = peripheralRepository;
    }

    public PeripheralEntity findPeripheralByUidOrFail(Long uid) {
        return this.peripheralRepository.findById(uid).orElseThrow(() -> new EntityNotFoundException("Peripheral"));
    }

    @Transactional(rollbackFor = Exception.class)
    public PeripheralEntity savePeripheralEntity(PeripheralEntity peripheralEntity) {
        return this.peripheralRepository.saveAndFlush(peripheralEntity);
    }

    public List<PeripheralEntity> findAll() {
        return this.peripheralRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public PeripheralEntity createPeripheral(CreatePeripheralRequest createPeripheralRequest) {
        PeripheralEntity peripheralEntity = new PeripheralEntity();
        peripheralEntity.setVendor(createPeripheralRequest.getVendor());
        peripheralEntity.setStatus(createPeripheralRequest.getStatus());
        return this.peripheralRepository.saveAndFlush(peripheralEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public PeripheralEntity updatePeripheral(Long uid, UpdatePeripheralRequest updatePeripheralRequest) {
        PeripheralEntity peripheralEntity = this.findPeripheralByUidOrFail(uid);
        peripheralEntity.setVendor(updatePeripheralRequest.getVendor());
        peripheralEntity.setStatus(updatePeripheralRequest.getStatus());
        return this.peripheralRepository.saveAndFlush(peripheralEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deletePeripheral(Long uid) {
        this.findPeripheralByUidOrFail(uid);
        this.peripheralRepository.deleteById(uid);
    }
}
