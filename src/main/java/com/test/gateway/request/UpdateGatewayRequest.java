package com.test.gateway.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateGatewayRequest {

    @ApiModelProperty(example = "Main Gateway", required = true)
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 30, message = "The gateway name '${validatedValue}' must be between {min} and {max} characters long")
    private String name;

    @ApiModelProperty(example = "188.56.14.37", required = true)
    @NotBlank(message = "Ipv4 address is mandatory")
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$", message="The address must be a valid ipv4 address")
    private String address;

    public UpdateGatewayRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
