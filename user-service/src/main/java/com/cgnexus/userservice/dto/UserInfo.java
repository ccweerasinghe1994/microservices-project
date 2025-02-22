package com.cgnexus.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserInfo {

    private UUID userId;

    private String name;

    private Integer age;

    private String gender;

    private String createdTime;

    private String updatedTime;

    private List<InvoiceDTO> invoiceList;
}
