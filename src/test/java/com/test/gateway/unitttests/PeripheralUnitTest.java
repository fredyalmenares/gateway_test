package com.test.gateway.unitttests;

import com.test.gateway.entity.PeripheralEntity;
import com.test.gateway.request.CreatePeripheralRequest;
import com.test.gateway.request.UpdatePeripheralRequest;
import com.test.gateway.service.PeripheralService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest()
public class PeripheralUnitTest {
    int PERIPHERAL_COUNT = 10;

    @Autowired
    PeripheralService peripheralService;

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findPeripheralByUidOrFail__then_return_EntityNotFoundException() {
        for (int i = 11; i <= 20; i++) {
            final Long uid = (long) i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.peripheralService.findPeripheralByUidOrFail(uid);
            });
            String expectedMessage = "Peripheral";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findPeripheralByUidOrFail__then_return_peripheral() {
        for (int i = 1; i <= PERIPHERAL_COUNT; i++) {
            final Long uid = (long) i;
            final String status = i % 2 == 1 ? "online" : "offline";
            final String vendor = "vendor" + i;

            PeripheralEntity peripheral = this.peripheralService.findPeripheralByUidOrFail(uid);

            assertThat(peripheral).isNotNull();
            assertThat(peripheral.getUid()).isEqualTo(uid);
            assertThat(peripheral.getStatus()).isEqualTo(status);
            assertThat(peripheral.getVendor()).isEqualTo(vendor);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findAll__then_return_gateway_collection() {
        List<PeripheralEntity> peripheralEntityList = this.peripheralService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(PeripheralEntity::getUid))
                .collect(Collectors.toList());
        assertThat(peripheralEntityList.size()).isEqualTo(PERIPHERAL_COUNT);
        for (int i = 1; i <= PERIPHERAL_COUNT; i++) {
            final Long uid = (long) i;
            final String status = i % 2 == 1 ? "online" : "offline";
            final String vendor = "vendor" + i;

            PeripheralEntity peripheral = peripheralEntityList.get(i - 1);

            assertThat(peripheral).isNotNull();
            assertThat(peripheral.getUid()).isEqualTo(uid);
            assertThat(peripheral.getStatus()).isEqualTo(status);
            assertThat(peripheral.getVendor()).isEqualTo(vendor);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_createPeripheral__then_create_peripheral() {
        List<PeripheralEntity> peripheralEntityList = this.peripheralService.findAll();
        for (int i = 1; i <= PERIPHERAL_COUNT; i++) {
            final String status = i % 2 == 1 ? "online" : "offline";
            final String vendor = "vendor" + i;

            assertThat(peripheralEntityList
                    .stream()
                    .filter(peripheralEntity -> peripheralEntity.getVendor().equals(vendor))
                    .count())
                    .isEqualTo(0);
            PeripheralEntity peripheral = this.peripheralService.createPeripheral(new CreatePeripheralRequest(vendor, status));

            assertThat(peripheral).isNotNull();
            assertThat(peripheral.getUid()).isNotNull();
            assertThat(peripheral.getStatus()).isEqualTo(status);
            assertThat(peripheral.getVendor()).isEqualTo(vendor);
        }
    }


    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_updatePeripheral__then_expect_EntityNotFoundException() {
        for (int i = 100; i <= 150; i++) {
            final Long uid = (long) i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.peripheralService.updatePeripheral(uid, new UpdatePeripheralRequest());
            });
            String expectedMessage = "Peripheral";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_updatePeripheral__then_expect_peripheral_updated() {
        for (int i = 1; i <= PERIPHERAL_COUNT; i++) {
            final Long uid = (long) i;
            final String status = i % 2 == 0 ? "online" : "offline";
            final String vendor = "vendor" + i;

            List<PeripheralEntity> peripheralEntityList = this.peripheralService.findAll();
            assertThat(peripheralEntityList
                    .stream()
                    .filter(
                            peripheralEntity ->
                                    peripheralEntity.getUid().equals(uid) &&
                                            peripheralEntity.getStatus().equals(status) &&
                                            peripheralEntity.getVendor().equals(vendor))
                    .count())
                    .isEqualTo(0);

            PeripheralEntity peripheral = this.peripheralService.updatePeripheral(uid, new UpdatePeripheralRequest(vendor, status));

            assertThat(peripheral).isNotNull();
            assertThat(peripheral.getUid()).isEqualTo(uid);
            assertThat(peripheral.getStatus()).isEqualTo(status);
            assertThat(peripheral.getVendor()).isEqualTo(vendor);

            peripheralEntityList = this.peripheralService.findAll();
            assertThat(peripheralEntityList
                    .stream()
                    .filter(
                            peripheralEntity ->
                                    peripheralEntity.getUid().equals(uid) &&
                                            peripheralEntity.getStatus().equals(status) &&
                                            peripheralEntity.getVendor().equals(vendor))
                    .count())
                    .isEqualTo(1);

        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_deletePeripheral__then_expect_EntityNotFoundException() {
        for (int i = 1; i <= PERIPHERAL_COUNT; i++) {
            final Long uid = (long) i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.peripheralService.deletePeripheral(uid);
            });
            String expectedMessage = "Peripheral";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_deletePeripheral__then_expect_delete_peripheral() {
        for (int i = 1; i <= PERIPHERAL_COUNT; i++) {
            final Long uid = (long) i;
            assertThat(this.peripheralService
                    .findAll()
                    .stream()
                    .filter(peripheralEntity -> peripheralEntity.getUid().equals(uid))
                    .count())
                    .isEqualTo(1);

            this.peripheralService.deletePeripheral(uid);

            assertThat(this.peripheralService
                    .findAll()
                    .stream()
                    .filter(peripheralEntity -> peripheralEntity.getUid().equals(uid))
                    .count())
                    .isEqualTo(0);
        }
    }
}
