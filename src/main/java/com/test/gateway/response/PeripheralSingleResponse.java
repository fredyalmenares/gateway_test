package com.test.gateway.response;

import com.test.gateway.entity.PeripheralEntity;
import io.swagger.annotations.ApiModelProperty;


public class PeripheralSingleResponse {

    @ApiModelProperty(example = "true")
    private boolean success;
    @ApiModelProperty(example = "Peripherals returned successfully.")
    private String message;
    private PeripheralEntity data;
    private int code;

    public PeripheralSingleResponse() {
        this.success = true;
        this.message = "Peripherals returned successfully.";
        this.data = null;
        this.code = 200;
    }

    public PeripheralSingleResponse(PeripheralEntity data) {
        this.success = true;
        this.message = "Peripherals returned successfully.";
        this.data = data;
        this.code = 200;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PeripheralEntity getData() {
        return data;
    }

    public void setData(PeripheralEntity data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


