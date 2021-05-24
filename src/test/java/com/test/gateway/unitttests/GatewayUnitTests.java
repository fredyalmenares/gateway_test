package com.test.gateway.unitttests;

import com.test.gateway.GatewayApplication;
import com.test.gateway.entity.GatewayEntity;
import com.test.gateway.exception.EntityAlreadyExistsException;
import com.test.gateway.exception.GatewayDoesNotHasPeripheralException;
import com.test.gateway.exception.GatewayMaxPeripheralsException;
import com.test.gateway.request.CreateGatewayRequest;
import com.test.gateway.request.UpdateGatewayRequest;
import com.test.gateway.service.GatewayService;
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
public class GatewayUnitTests {
    int GATEWAY_COUNT = 5;

    @Autowired
    GatewayService gatewayService;

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findGatewayBySerialOrFail__then_return_gateway() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            String serial = i + "ABC";
            String address = "192.147.25." + i;
            String name = "Gateway" + i;
            GatewayEntity gateway = this.gatewayService.findGatewayBySerialOrFail(serial);
            assertThat(gateway).isNotNull();
            assertThat(gateway.getSerial()).isEqualTo(serial);
            assertThat(gateway.getAddress()).isEqualTo(address);
            assertThat(gateway.getName()).isEqualTo(name);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findGatewayBySerialOrFail__then_expect_EntityNotFoundException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            final String serial = "DONT EXISTS" + i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.findGatewayBySerialOrFail(serial);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findAll__then_return_gateway_collection() {
        List<GatewayEntity> gatewayEntityList = this.gatewayService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(gatewayEntity -> (int) gatewayEntity.getSerial().charAt(0)))
                .collect(Collectors.toList());
        assertThat(gatewayEntityList.size()).isEqualTo(5);
        var ref = new Object() {
            int i = 1;
        };
        gatewayEntityList.forEach(gatewayEntity -> {
            String serial = ref.i + "ABC";
            String address = "192.147.25." + ref.i;
            String name = "Gateway" + ref.i;
            assertThat(gatewayEntity).isNotNull();
            assertThat(gatewayEntity.getSerial()).isEqualTo(serial);
            assertThat(gatewayEntity.getAddress()).isEqualTo(address);
            assertThat(gatewayEntity.getName()).isEqualTo(name);
            ref.i++;
        });
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_createGateway__then_return_created_gateway() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            String serial = i + "ABC";
            String address = "192.147.25." + i;
            String name = "Gateway" + i;
            GatewayEntity gateway = null;
            gateway = this.gatewayService.createGateway(new CreateGatewayRequest(serial, name, address));
            assertThat(gateway).isNotNull();
            assertThat(gateway.getSerial()).isEqualTo(serial);
            assertThat(gateway.getAddress()).isEqualTo(address);
            assertThat(gateway.getName()).isEqualTo(name);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_createGateway__then_expect_EntityAlreadyExistsException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            final String serial = i + "ABC";
            final String address = "192.147.25." + i;
            final String name = "Gateway" + i;
            Exception exception = assertThrows(EntityAlreadyExistsException.class, () -> {
                this.gatewayService.createGateway(new CreateGatewayRequest(serial, name, address));
            });
            String expectedMessage = "Gateway with serial";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).contains(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_updateGateway__then_expect_EntityNotFoundException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            final String serial = "DONT EXISTS" + i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.updateGateway(serial, new UpdateGatewayRequest());
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_updateGateway__then_expect_gateway_updated() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            String serial = i + "ABC";
            String address = "1.1.1." + i;
            String name = "Gateway" + i + " UPDATED";
            GatewayEntity gateway = this.gatewayService.updateGateway(serial, new UpdateGatewayRequest(name, address));
            assertThat(gateway).isNotNull();
            assertThat(gateway.getSerial()).isEqualTo(serial);
            assertThat(gateway.getAddress()).isEqualTo(address);
            assertThat(gateway.getName()).isEqualTo(name);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways2.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_deleteGateway__then_expect_EntityNotFoundException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            final String serial = "DONT EXISTS" + i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.deleteGateway(serial);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGatewaysWithPeripheralsFull.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_deleteGateway__then_expect_GatewayHasPeripheralException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            final String serial = "DONT EXISTS" + i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.deleteGateway(serial);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways2.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_deleteGateway__then_expect_gateway_deleted() {
        for (int i = 10; i <= 19; i++) {
            final String serial = i + "ABC";
            GatewayEntity gateway = this.gatewayService.findGatewayBySerialOrFail(serial);
            assertThat(gateway).isNotNull();
            this.gatewayService.deleteGateway(gateway.getSerial());

            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.findGatewayBySerialOrFail(serial);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);

        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGateways2.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_addPeripheralToGateway__then_expect_peripheral_not_found() {
        for (int i = 10; i <= 19; i++) {
            final String serial = i + "ABC";
            final Long uid = (long) (i * i);
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.addPeripheralToGateway(serial, uid);
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
    public void when_call_addPeripheralToGateway__then_expect_gateway_not_found() {
        for (int i = 1; i <= 10; i++) {
            final String serial = i + "ABCEFGH";
            final Long uid = (long) i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.addPeripheralToGateway(serial, uid);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGatewaysWithPeripheralsFullWithUnatachedPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_addPeripheralToGateway__then_expect_gateway_max_peripherals() {
        for (int i = 1; i <= 3; i++) {
            final String serial = i + "ABC";
            for (int j = 30; j <= 40; j++) {
                final Long uid = (long) j;
                Exception exception = assertThrows(GatewayMaxPeripheralsException.class, () -> {
                    this.gatewayService.addPeripheralToGateway(serial, uid);
                });
                String expectedMessage = "No more peripherals can be added to it";
                String actualMessage = exception.getMessage();
                assertThat(actualMessage).contains(expectedMessage);
            }
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGatewaysWithWithoutPeripheralsWithUnattachedPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_addPeripheralToGateway__then_expect_add_peripheral_to_gateway() {
        for (int i = 1; i <= 3; i++) {
            final String serial = i + "ABC";
            for (int j = 1; j <= 10; j++) {
                final Long uid = (long) j + ((i - 1) * 10L);
                GatewayApplication.logger.warn("SERIAL: " + serial + " UID: " + uid);
                this.gatewayService.addPeripheralToGateway(serial, uid);
                assertThat(
                        this.gatewayService
                                .findGatewayBySerialOrFail(serial)
                                .getPeripherals()
                                .stream()
                                .filter(peripheralEntity -> peripheralEntity.getUid().equals(uid))
                                .count())
                        .isEqualTo(1);

            }
        }
    }

    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGatewaysWithPeripheralsFull.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_removePeripheralFromGateway__then_expect_remove_peripheral_from_gateway() {
        for (int i = 1; i <= 3; i++) {
            final String serial = i + "ABC";
            for (int j = 1; j <= 10; j++) {
                final Long uid = (long) j + ((i - 1) * 10L);
                GatewayApplication.logger.warn("SERIAL: " + serial + " UID: " + uid);
                assertThat(
                        this.gatewayService
                                .findGatewayBySerialOrFail(serial)
                                .getPeripherals()
                                .stream()
                                .filter(peripheralEntity -> peripheralEntity.getUid().equals(uid))
                                .count())
                        .isEqualTo(1);
                this.gatewayService.removePeripheralFromGateway(serial, uid);

                this.gatewayService
                        .findGatewayBySerialOrFail(serial)
                        .getPeripherals()
                        .forEach(peripheral -> GatewayApplication.logger.warn(peripheral.toString()));

                assertThat(
                        this.gatewayService
                                .findGatewayBySerialOrFail(serial)
                                .getPeripherals()
                                .stream()
                                .filter(peripheralEntity ->
                                        peripheralEntity.getGateway() != null &&
                                                peripheralEntity.getUid().equals(uid)
                                )
                                .count())
                        .isEqualTo(0);
            }
        }
    }


    @Test
    @Transactional
    @Sql(scripts = {"/removeAll.sql", "/createGatewaysWithWithoutPeripheralsWithUnattachedPeripherals.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_removePeripheralFromGateway__then_expect_gateway_does_not_have_peripheral_exception() {
        for (int i = 1; i <= 3; i++) {
            final String serial = i + "ABC";
            for (int j = 1; j <= 10; j++) {
                final Long uid = (long) j + ((i - 1) * 10L);
                GatewayApplication.logger.warn("SERIAL: " + serial + " UID: " + uid);
                assertThat(
                        this.gatewayService
                                .findGatewayBySerialOrFail(serial)
                                .getPeripherals()
                                .stream()
                                .filter(peripheralEntity -> peripheralEntity.getUid().equals(uid))
                                .count())
                        .isEqualTo(0);

                Exception exception = assertThrows(GatewayDoesNotHasPeripheralException.class, () -> {
                    this.gatewayService.removePeripheralFromGateway(serial, uid);
                });
                String expectedMessage = "does not contain the peripheral with uid";
                String actualMessage = exception.getMessage();
                assertThat(actualMessage).contains(expectedMessage);
            }
        }
    }

}
