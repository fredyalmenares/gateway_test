package com.test.gateway.response;

import com.test.gateway.entity.PeripheralEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Collection;


public class PeripheralCollectionResponse {

    @ApiModelProperty(example = "true")
    private boolean success;
    @ApiModelProperty(example = "Peripherals returned successfully.")
    private String message;
    private Collection<PeripheralEntity> data;
    private int code;

    public PeripheralCollectionResponse() {
        this.success = true;
        this.message = "Peripherals returned successfully.";
        this.data = new ArrayList<>();
        this.code = 200;
    }

    public PeripheralCollectionResponse(Collection<PeripheralEntity> data) {
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

    public Collection<PeripheralEntity> getData() {
        return data;
    }

    public void setData(Collection<PeripheralEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


