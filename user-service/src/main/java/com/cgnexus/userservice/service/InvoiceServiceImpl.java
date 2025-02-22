package com.cgnexus.userservice.service;

import com.cgnexus.userservice.client.InvoiceServiceFeignClient;
import com.cgnexus.userservice.dto.InvoiceDTO;
import com.cgnexus.userservice.exception.InvoiceException;
import com.cgnexus.userservice.exception.UserException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceServiceFeignClient invoiceServiceFeignClient;

    @Override
    public List<InvoiceDTO> getAllInvoicesByUserId(String userId) throws InvoiceException {
        try {
            return invoiceServiceFeignClient.callInvoiceServiceToGetAllInvoicesByUserId(userId).getData();
        } catch (FeignException.ServiceUnavailable serviceUnavailable) {
            throw new UserException("Invoice service is unavailable", List.of("Invoice service is unavailable"), HttpStatus.SERVICE_UNAVAILABLE.value());
        } catch (FeignException.NotFound notFound) {
            throw new UserException("Invoices not found", List.of("Invoices not found"), HttpStatus.NOT_FOUND.value());
        } catch (FeignException.BadRequest badRequest) {
            throw new UserException("Bad request", List.of("Bad request"), HttpStatus.BAD_REQUEST.value());

        }

    }
}
