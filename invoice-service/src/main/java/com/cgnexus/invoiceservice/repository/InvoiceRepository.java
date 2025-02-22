package com.cgnexus.invoiceservice.repository;

import com.cgnexus.invoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
    List<Invoice> findAllByUserId(String userId);
}
