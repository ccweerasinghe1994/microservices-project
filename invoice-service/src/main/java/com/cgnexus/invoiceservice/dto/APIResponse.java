package com.cgnexus.invoiceservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class APIResponse<T> {
    private Instant timestamp;
    private Integer status;
    private String path;
    private T data;
    private ErrorDTO error;
}
