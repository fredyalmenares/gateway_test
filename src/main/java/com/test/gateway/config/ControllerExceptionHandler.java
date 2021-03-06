package com.test.gateway.config;

import com.test.gateway.GatewayApplication;
import com.test.gateway.exception.EntityAlreadyExistsException;
import com.test.gateway.exception.GatewayDoesNotHasPeripheralException;
import com.test.gateway.exception.GatewayHasPeripheralException;
import com.test.gateway.exception.GatewayMaxPeripheralsException;
import com.test.gateway.response.BadRequestResponse;
import com.test.gateway.response.NotFoundResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GatewayApplication.logger.warn(ex.getMessage());
        List<String> errors = ex.getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new BadRequestResponse(errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<NotFoundResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(new NotFoundResponse(e.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {GatewayHasPeripheralException.class})
    protected ResponseEntity<BadRequestResponse> handleGatewayHasPeripheralException(GatewayHasPeripheralException e) {
        return new ResponseEntity<>(new BadRequestResponse(Collections.singletonList(e.getMessage()+" Please unlink all peripherals from the gateway before deleting it.")), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {GatewayMaxPeripheralsException.class, GatewayDoesNotHasPeripheralException.class, EntityAlreadyExistsException.class})
    protected ResponseEntity<BadRequestResponse> handleGatewayException(RuntimeException re) {
        return new ResponseEntity<>(new BadRequestResponse(Collections.singletonList(re.getMessage())), HttpStatus.BAD_REQUEST);
    }




}
