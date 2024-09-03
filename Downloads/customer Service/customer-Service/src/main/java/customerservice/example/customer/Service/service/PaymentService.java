package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.InvoiceDTO;
import customerservice.example.customer.Service.dto.PaymentDTO;
import customerservice.example.customer.Service.dto.ReceiptDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


/**
 * service for processing payment request(saving  payment details).
 */
    public interface PaymentService {
    /**
     *
     * @param paymentDTO  payment data transfer object for saving  required payment details .
     * @return  String message to know the status of payment .
     */

    String processPayment(PaymentDTO paymentDTO);


    }



