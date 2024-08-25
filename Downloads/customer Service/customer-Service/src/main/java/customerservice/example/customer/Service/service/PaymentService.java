package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.InvoiceDTO;
import customerservice.example.customer.Service.dto.PaymentDTO;
import customerservice.example.customer.Service.dto.ReceiptDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;



    public interface PaymentService {


        String processPayment(PaymentDTO paymentDTO);


//        InvoiceDTO getInvoice(UUID invoiceId);
//        ReceiptDTO getReceipt(UUID receiptId);
    }



