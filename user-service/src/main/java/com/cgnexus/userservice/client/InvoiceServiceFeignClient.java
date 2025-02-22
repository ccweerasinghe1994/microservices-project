package com.cgnexus.userservice.client;

import com.cgnexus.userservice.dto.APIResponse;
import com.cgnexus.userservice.dto.InvoiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(url = "${invoice.service.url}", name = "invoice-service-feign-client", path = "/v1")
public interface InvoiceServiceFeignClient {

    @GetMapping("/invoices")
    APIResponse<List<InvoiceDTO>> callInvoiceServiceToGetAllInvoicesByUserId(@RequestParam("userId") String userId);
}
