package com.test.gateway.controller;

import com.test.gateway.request.CreateGatewayRequest;
import com.test.gateway.request.UpdateGatewayRequest;
import com.test.gateway.response.GatewayCollectionResponse;
import com.test.gateway.response.GatewaySingleResponse;
import com.test.gateway.service.GatewayService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("gateway")
@Api(value = "Gateway", tags = {"Gateway"})
@Validated
public class GatewayController {

    private GatewayService gatewayService;

    public GatewayController(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @GetMapping
    @ApiOperation(value = "Get all stored gateways.", tags = {"Gateway"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GatewayCollectionResponse> getGateways() {
        GatewayCollectionResponse response = new GatewayCollectionResponse(this.gatewayService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{serial}")
    @ApiOperation(value = "Get one gateway by its serial.", tags = {"Gateway"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GatewaySingleResponse> getGatewayBySerial(@PathVariable(name = "serial") String serial) {
        GatewaySingleResponse response = new GatewaySingleResponse(this.gatewayService.findGatewayBySerialOrFail(serial));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new Gateway.", tags = {"Gateway"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Gateway created successfully.", response = GatewaySingleResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Bad Request\", \"code\": 400, \"errors\": [\"error1\", \"error2\"]}")
                    }))})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GatewaySingleResponse> postGateways(@Valid @RequestBody() CreateGatewayRequest createGatewayRequest) {
        GatewaySingleResponse response = new GatewaySingleResponse(this.gatewayService.createGateway(createGatewayRequest));
        response.setMessage("Gateway created successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{serial}")
    @ApiOperation(value = "Update an existing Gateway.", tags = {"Gateway"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad Request", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Bad Request\", \"code\": 400, \"errors\": [\"error1\", \"error2\"]}")
                    }))})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GatewaySingleResponse> updateGateway(@PathVariable(name = "serial") String serial, @Valid @RequestBody() UpdateGatewayRequest updateGatewayRequest) {
        GatewaySingleResponse response = new GatewaySingleResponse(this.gatewayService.updateGateway(serial, updateGatewayRequest));
        response.setMessage("Gateway updated successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ApiOperation(value = "Delete an existing Gateway.", tags = {"Gateway"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "Not Found", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Not Found\", \"code\": 404}")
                    }))})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GatewaySingleResponse> deleteGateway(@PathVariable(name = "serial") String serial) {
        this.gatewayService.deleteGateway(serial);
        GatewaySingleResponse response = new GatewaySingleResponse();
        response.setMessage("Gateway deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{serial}/addPeripheral/{uid}")
    @ApiOperation(value = "Add a peripheral to a gateway.", tags = {"Gateway"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "Not Found", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Not Found\", \"code\": 404}")
                    }))})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GatewaySingleResponse> addPeripheral(@PathVariable(name = "serial") String serial, @PathVariable(name = "uid") Long uid) {
        GatewaySingleResponse response = new GatewaySingleResponse(this.gatewayService.addPeripheralToGateway(serial, uid));
        response.setMessage("Peripheral added successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{serial}/removePeripheral/{uid}")
    @ApiOperation(value = "Remove a peripheral from a gateway.", tags = {"Gateway"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "Not Found", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Not Found\", \"code\": 404}")
                    }))})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<GatewaySingleResponse> removePeripheral(@PathVariable(name = "serial") String serial, @PathVariable(name = "uid") Long uid) {
        GatewaySingleResponse response = new GatewaySingleResponse(this.gatewayService.removePeripheralFromGateway(serial, uid));
        response.setMessage("Peripheral removed successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
