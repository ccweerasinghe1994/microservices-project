package com.cgnexus.userservice.service;

import com.cgnexus.userservice.dto.InvoiceDTO;
import com.cgnexus.userservice.exception.InvoiceException;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDTO> getAllInvoicesByUserId(String userId) throws InvoiceException;
}
