package com.cgnexus.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class InvoiceDTO {

    private UUID invoiceId;

    private String invoiceNumber;

    private String productIds;

    private String updateTime;
}
