package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.ReceiptDTO;

import java.util.UUID;

public interface ReceiptService {
    ReceiptDTO generateReceipt(UUID customerId);
}
