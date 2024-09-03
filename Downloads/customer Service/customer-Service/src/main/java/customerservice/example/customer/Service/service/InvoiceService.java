package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.InvoiceDTO;

import java.util.UUID;

/**
 * service for generating invoices.
 */
public interface InvoiceService {
    /**
     *
     * @param id  the id for which we want to generate the invoice.
     * @return response as invoiceDTO containing attributes like amount , invoice date and customerId etc.
     */
    InvoiceDTO generateInvoice (UUID id);
}
