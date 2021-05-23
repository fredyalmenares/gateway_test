package com.test.gateway.exception;

public class GatewayDoesNotHasPeripheralException extends RuntimeException {

    private final String serial;
    private final Long uid;

    public GatewayDoesNotHasPeripheralException(String serial, Long uid) {
        super("The Gateway with serial "+serial+" does not contain the peripheral with uid "+uid+".");
        this.serial = serial;
        this.uid = uid;
    }

    public String getSerial() {
        return serial;
    }

    public Long getUid() {
        return uid;
    }
}
