package com.test.gateway.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdatePeripheralRequest {
    @ApiModelProperty(example = "vendor1", required = true)
    @NotBlank(message = "Vendor is mandatory")
    @Size(min = 3, max = 30, message = "The vendor name '${validatedValue}' must be between {min} and {max} characters long")
    private String vendor;

    @ApiModelProperty(example = "online")
    @Pattern(regexp = "^online|offline$", message="The status must be online or offline")
    private String status;

    @ApiModelProperty(example = "123LR90Y")
    private String gatewaySerial;


    public UpdatePeripheralRequest() {
    }

    public UpdatePeripheralRequest(String vendor, String status) {
        this.vendor = vendor;
        this.status = status;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGatewaySerial() {
        return gatewaySerial;
    }

    public void setGatewaySerial(String gatewaySerial) {
        this.gatewaySerial = gatewaySerial;
    }
}
