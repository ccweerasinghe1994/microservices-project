package com.cgnexus.invoiceservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorDTO {

    private String errorMessage;

    private List<String> errorDetails;
}
