package com.cgnexus.invoiceservice.service;

import com.cgnexus.invoiceservice.dto.InvoiceDTO;
import com.cgnexus.invoiceservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDTO> getAllInvoicesByUserId(String userId);
}
