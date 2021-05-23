package com.test.gateway.controller;

import com.test.gateway.request.CreatePeripheralRequest;
import com.test.gateway.request.UpdatePeripheralRequest;
import com.test.gateway.response.PeripheralCollectionResponse;
import com.test.gateway.response.PeripheralSingleResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("peripheral")
@Api(value = "Peripheral", tags = {"Peripheral"})
@Validated
public class PeripheralController {

    @GetMapping
    @ApiOperation(value = "Get all stored peripherals.", tags = {"Peripheral"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PeripheralCollectionResponse> getPeripherals() {
        PeripheralCollectionResponse response = new PeripheralCollectionResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{uid}")
    @ApiOperation(value = "Get one peripheral by its uid.", tags = {"Peripheral"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PeripheralSingleResponse> getPeripheralByUid(@PathVariable(name = "uid") String uid) {
        PeripheralSingleResponse response = new PeripheralSingleResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a new Peripheral.", tags = {"Peripheral"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Peripheral created successfully.", response = PeripheralSingleResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Bad Request\", \"code\": 400, \"errors\": [\"error1\", \"error2\"]}")
                    }))})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PeripheralSingleResponse> postPeripherals(@Valid @RequestBody() CreatePeripheralRequest createPeripheralRequest) {
        PeripheralSingleResponse response = new PeripheralSingleResponse();
        response.setMessage("Peripheral created successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{uid}")
    @ApiOperation(value = "Update an existing Peripheral.", tags = {"Peripheral"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 400, message = "Bad Request", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Bad Request\", \"code\": 400, \"errors\": [\"error1\", \"error2\"]}")
                    }))})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PeripheralSingleResponse> updatePeripheral(@PathVariable(name = "uid") String uid, @Valid @RequestBody() UpdatePeripheralRequest updatePeripheralRequest) {
        PeripheralSingleResponse response = new PeripheralSingleResponse();
        response.setMessage("Peripheral updated successfully.");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uid}")
    @ApiOperation(value = "Delete an existing Peripheral.", tags = {"Peripheral"})
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "Not Found", examples = @Example({
                            @ExampleProperty(mediaType = "*/*", value = "{\"success\": false, \"message\":\"Not Found\", \"code\": 404}")
                    }))})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PeripheralSingleResponse> deletePeripheral(@PathVariable(name = "uid") String uid) {
        PeripheralSingleResponse response = new PeripheralSingleResponse();
        response.setMessage("Peripheral deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
