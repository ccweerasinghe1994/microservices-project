package com.cgnexus.userservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
public class InvoiceException extends RuntimeException {

  private String errorMessage;

  private List<String> errorDetails;

  private Integer statusCode;

  public InvoiceException(String errorMessage, List<String> errorDetails, Integer statusCode) {
    super(errorMessage);
    this.errorMessage = errorMessage;
    this.errorDetails = errorDetails;
    this.statusCode = statusCode;
  }
}
