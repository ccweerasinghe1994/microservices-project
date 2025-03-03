package com.cgnexus.userservice.exception;

import com.cgnexus.userservice.dto.APIResponse;
import com.cgnexus.userservice.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<APIResponse<Void>> handleMissingParams(MissingServletRequestParameterException ex, WebRequest request) {
        ErrorDTO requiredParameterIsMissing = ErrorDTO.builder()
                .errorMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .errorDetails(List.of("Required request parameter " + ex.getParameterName() + " is missing"))
                .build();
        APIResponse<Void> response = APIResponse.<Void>builder()
                .error(requiredParameterIsMissing)
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now())
                .path(request.getDescription(false).split("=")[1])
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvoiceException.class)
    public ResponseEntity<APIResponse<Void>> handleInvoiceException(InvoiceException ex, WebRequest request) {
        return getApiResponseResponseEntity(request, ex.getErrorMessage(), ex.getErrorDetails(), ex.getStatusCode());
    }


    @ExceptionHandler(UserException.class)
    public ResponseEntity<APIResponse<Void>> handleUserException(UserException ex, WebRequest request) {
        return getApiResponseResponseEntity(request, ex.getErrorMessage(), ex.getErrorDetails(), ex.getStatusCode());
    }

    @ExceptionHandler(InvalidUserIdException.class)
    public ResponseEntity<APIResponse<Void>> handleInvalidUserIdException(InvalidUserIdException ex, WebRequest request) {
        return getApiResponseResponseEntity(request, ex.getErrorMessage(), ex.getErrorDetails(), ex.getStatusCode());
    }

    private ResponseEntity<APIResponse<Void>> getApiResponseResponseEntity(WebRequest request, String errorMessage, List<String> errorDetails, Integer statusCode) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorMessage(errorMessage)
                .errorDetails(errorDetails)
                .build();
        APIResponse<Void> response = APIResponse.<Void>builder()
                .error(errorDTO)
                .status(statusCode)
                .timestamp(Instant.now())
                .path(request.getDescription(false).split("=")[1])
                .build();
        return ResponseEntity.status(statusCode).body(response);
    }
}
