package com.cgnexus.userservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidUserIdException extends RuntimeException {

    private String errorMessage;

    private List<String> errorDetails;

    private Integer statusCode;

    public InvalidUserIdException(String errorMessage, List<String> errorDetails, Integer statusCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
        this.statusCode = statusCode;
    }
}
