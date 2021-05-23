package com.test.gateway.exception;

public class GatewayHasPeripheralException extends RuntimeException {

    private final String serial;

    public GatewayHasPeripheralException(String serial) {
        super("The Gateway with serial "+serial+" has at least one peripheral attached.");
        this.serial = serial;
    }

    public String getSerial() {
        return serial;
    }
}
