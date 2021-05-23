package com.test.gateway.unitttests;

import com.test.gateway.entity.GatewayEntity;
import com.test.gateway.exception.EntityAlreadyExistsException;
import com.test.gateway.request.CreateGatewayRequest;
import com.test.gateway.service.GatewayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

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
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findGatewayBySerialOrFail__then_expect_EntityNotFoundException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            String serial = "DONT EXISTS" + i;
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                this.gatewayService.findGatewayBySerialOrFail(serial);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
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
    @Sql(scripts = {"/removeAll.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_createGateway__then_return_created_gateway() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            String serial = i + "ABC";
            String address = "192.147.25." + i;
            String name = "Gateway" + i;
            GatewayEntity gateway = null;
            try {
                gateway = this.gatewayService.createGateway(new CreateGatewayRequest(serial, name, address));
            } catch (EntityAlreadyExistsException e) {
                e.printStackTrace();
            }
            assertThat(gateway).isNotNull();
            assertThat(gateway.getSerial()).isEqualTo(serial);
            assertThat(gateway.getAddress()).isEqualTo(address);
            assertThat(gateway.getName()).isEqualTo(name);
        }
    }

    @Test
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_createGateway__then_expect_EntityAlreadyExistsException() {
        for (int i = 1; i <= GATEWAY_COUNT; i++) {
            String serial = i + "ABC";
            String address = "192.147.25." + i;
            String name = "Gateway" + i;
            Exception exception = assertThrows(EntityAlreadyExistsException.class, () -> {
                this.gatewayService.createGateway(new CreateGatewayRequest(serial, name, address));
            });
            String expectedMessage = "Gateway with serial";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).contains(expectedMessage);
        }
    }

}
