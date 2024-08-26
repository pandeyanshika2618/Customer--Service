package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.InvoiceDTO;

import java.util.UUID;

public interface InvoiceService {
    InvoiceDTO generateInvoice (UUID id);
}
