package com.test.gateway.response;

import com.test.gateway.entity.GatewayEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Collection;


public class GatewayCollectionResponse {

    @ApiModelProperty(example = "true")
    private boolean success;
    @ApiModelProperty(example = "Gateways returned successfully.")
    private String message;
    private Collection<GatewayEntity> data;
    private int code;

    public GatewayCollectionResponse() {
        this.success = true;
        this.message = "Gateways returned successfully.";
        this.data = new ArrayList<>();
        this.code = 200;
    }

    public GatewayCollectionResponse(Collection<GatewayEntity> data) {
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

    public Collection<GatewayEntity> getData() {
        return data;
    }

    public void setData(Collection<GatewayEntity> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


