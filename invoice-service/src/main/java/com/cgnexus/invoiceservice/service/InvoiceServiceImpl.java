package com.cgnexus.invoiceservice.service;

import com.cgnexus.invoiceservice.dto.InvoiceDTO;
import com.cgnexus.invoiceservice.entities.Invoice;
import com.cgnexus.invoiceservice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {


    private final InvoiceRepository invoiceRepository;

    @Override
    public List<InvoiceDTO> getAllInvoicesByUserId(String userId) {

        List<Invoice> allByUserId = invoiceRepository.findAllByUserId(userId);

        return allByUserId.stream()
                .map(invoice -> InvoiceDTO.builder()
                        .invoiceId(invoice.getInvoiceId())
                        .invoiceNumber(invoice.getInvoiceNumber())
                        .productIds(invoice.getProductIds())
                        .updateTime(invoice.getUpdateTime().toString())
                        .build())
                .toList();
    }
}
