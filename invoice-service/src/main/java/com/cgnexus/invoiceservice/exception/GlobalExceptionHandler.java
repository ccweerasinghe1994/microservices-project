package com.cgnexus.invoiceservice.exception;

import com.cgnexus.invoiceservice.dto.APIResponse;
import com.cgnexus.invoiceservice.dto.ErrorDTO;
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
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorMessage(ex.getErrorMessage())
                .errorDetails(ex.getErrorDetails())
                .build();
        APIResponse<Void> response = APIResponse.<Void>builder()
                .error(errorDTO)
                .status(ex.getStatusCode())
                .timestamp(Instant.now())
                .path(request.getDescription(false).split("=")[1])
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(response);
    }
}
