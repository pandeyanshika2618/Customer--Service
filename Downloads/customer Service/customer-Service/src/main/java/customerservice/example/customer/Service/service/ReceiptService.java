package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.ReceiptDTO;

import java.util.UUID;

/**
 * Service for generating receipt of the order.
 */
public interface ReceiptService {
    /**
     *
     * @param customerId the id of the customer who want to generate receipt.
     * @return  ReceiptDTO response data tranfer object containing attributes such as amount , paymentdate and customerId.
     */
    ReceiptDTO generateReceipt(UUID customerId);
}
