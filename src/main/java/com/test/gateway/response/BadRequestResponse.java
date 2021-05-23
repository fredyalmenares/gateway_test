package com.test.gateway.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.Collection;


public class BadRequestResponse {

    @ApiModelProperty(example = "false")
    private boolean success;
    @ApiModelProperty(example = "Bad request.")
    private String message;
    private Collection<String> errors;
    private int code;

    public BadRequestResponse(Collection<String> errors) {
        this.success = false;
        this.message="Bad request.";
        this.code=400;
        this.errors = errors;
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

    public Collection<String> getErrors() {
        return errors;
    }

    public void setErrors(Collection<String> errors) {
        this.errors = errors;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


