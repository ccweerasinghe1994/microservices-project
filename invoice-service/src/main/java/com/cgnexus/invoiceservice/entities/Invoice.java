package com.cgnexus.invoiceservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Table(schema = "invoice_db", name = "invoice")
public class Invoice {
    @Id
    @UuidGenerator
    @Column(name = "invoice_id", nullable = false)
    private UUID invoiceId;

    @Column(name = "user_id", nullable = false, length = 200)
    private String userId;

    @Column(name = "invoice_number", nullable = false, length = 500)
    private String invoiceNumber;

    @Column(name = "product_ids", nullable = false, length = Integer.MAX_VALUE)
    private String productIds;

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private Instant createTime;

    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private Instant updateTime;
}
