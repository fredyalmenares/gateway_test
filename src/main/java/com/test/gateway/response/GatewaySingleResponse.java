package com.test.gateway.response;

import com.test.gateway.entity.GatewayEntity;
import io.swagger.annotations.ApiModelProperty;


public class GatewaySingleResponse {

    @ApiModelProperty(example = "true")
    private boolean success;
    @ApiModelProperty(example = "Gateways returned successfully.")
    private String message;
    private GatewayEntity data;
    private int code;

    public GatewaySingleResponse() {
        this.success = true;
        this.message = "Gateways returned successfully.";
        this.data = null;
        this.code = 200;
    }

    public GatewaySingleResponse(GatewayEntity data) {
        this.success = true;
        this.message = "Gateways returned successfully.";
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

    public GatewayEntity getData() {
        return data;
    }

    public void setData(GatewayEntity data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


