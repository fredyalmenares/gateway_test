package com.test.gateway.exception;

public class GatewayMaxPeripheralsException extends RuntimeException {

    private final String serial;

    public GatewayMaxPeripheralsException(String serial) {
        super("The Gateway with serial " + serial + " is full. No more peripherals can be added to it.");
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }
}
