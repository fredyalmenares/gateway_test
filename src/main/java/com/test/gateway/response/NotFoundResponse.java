package com.test.gateway.response;

import io.swagger.annotations.ApiModelProperty;


public class NotFoundResponse {

    @ApiModelProperty(example = "false")
    private boolean success;
    @ApiModelProperty(example = "Not Found")
    private String message;
    private int code;

    public NotFoundResponse(String entity) {
        this.success = false;
        this.message = entity + " not found.";
        this.code = 404;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


