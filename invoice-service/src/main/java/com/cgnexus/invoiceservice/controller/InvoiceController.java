package com.cgnexus.invoiceservice.controller;

import com.cgnexus.invoiceservice.dto.APIResponse;
import com.cgnexus.invoiceservice.dto.InvoiceDTO;
import com.cgnexus.invoiceservice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService inventoryService;

    @GetMapping("/invoices")
    public ResponseEntity<APIResponse<List<InvoiceDTO>>> getAllInvoicesByUserId(@RequestParam("userId") String userId, WebRequest request) {

        List<InvoiceDTO> allInvoices = inventoryService.getAllInvoicesByUserId(userId);
        String path = request.getDescription(false).split("=")[1];
        APIResponse<List<InvoiceDTO>> response = APIResponse.<List<InvoiceDTO>>builder()
                .data(allInvoices)
                .path(path)
                .status(HttpStatus.OK.value())
                .timestamp(java.time.Instant.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
