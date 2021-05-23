package com.test.gateway.unitttests;

import com.test.gateway.entity.GatewayEntity;
import com.test.gateway.service.GatewayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest()
public class GatewayUnitTests {
    @Autowired
    GatewayService gatewayService;

    @Test
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findGatewayBySerialOrFail__then_return_gateway() {
        for (int i = 1; i <= 5; i++) {
            String serial = "ABC" + i;
            String address = "192.147.25." + i;
            String name = "Gateway" + i;
            GatewayEntity gateway = gatewayService.findGatewayBySerialOrFail(serial);
            assertThat(gateway).isNotNull();
            assertThat(gateway.getSerial()).isEqualTo(serial);
            assertThat(gateway.getAddress()).isEqualTo(address);
            assertThat(gateway.getName()).isEqualTo(name);
        }
    }

    @Test
    @Sql(scripts = {"/removeAll.sql", "/createGateways.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/removeAll.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void when_call_findGatewayBySerialOrFail__then_expect_Exception() {
        for (int i = 1; i <= 5; i++) {
            String serial = "DONT EXISTS" + i;
            GatewayEntity gateway = gatewayService.findGatewayBySerialOrFail(serial);
            Exception exception = assertThrows(EntityNotFoundException.class, () -> {
                gatewayService.findGatewayBySerialOrFail(serial);
            });
            String expectedMessage = "Gateway";
            String actualMessage = exception.getMessage();
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

}
