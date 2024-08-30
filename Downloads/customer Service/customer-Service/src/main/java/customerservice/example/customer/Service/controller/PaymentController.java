package customerservice.example.customer.Service.controller;


import customerservice.example.customer.Service.dto.InvoiceDTO;
import customerservice.example.customer.Service.dto.PaymentDTO;
import customerservice.example.customer.Service.dto.ReceiptDTO;
import customerservice.example.customer.Service.service.InvoiceService;
import customerservice.example.customer.Service.service.PaymentService;
import customerservice.example.customer.Service.service.ReceiptService;
import customerservice.example.customer.Service.service.impl.TokenValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {

    private PaymentService paymentService ;
    private InvoiceService invoiceService;
    private ReceiptService  receiptService ;
    private TokenValidation tokenValidation;

    @Autowired
    public PaymentController(PaymentService paymentService  , InvoiceService invoiceService , ReceiptService receiptService, TokenValidation tokenValidation)
    {
        this.paymentService = paymentService;
        this.invoiceService = invoiceService;
        this.receiptService =  receiptService;

        this.tokenValidation = tokenValidation;
    }

    @PostMapping("/payment/process")
    public ResponseEntity<String> processPayment(@Valid @RequestBody PaymentDTO paymentDTO , @RequestHeader("Authorization") String token , @RequestHeader("UserId") String userId)throws Exception{

        tokenValidation.isTokenValid(token , UUID.fromString(userId));
        String invoiceId = paymentService.processPayment(paymentDTO);
       // String response = paymentService.processPayment(paymentDTO);
       // return ResponseEntity.ok(response);
        return ResponseEntity.ok("Payment done successfully. Invoice ID: " + invoiceId);
    }





    @GetMapping("/payment/invoice/{customer_id}")
    public InvoiceDTO getInvoice(@PathVariable("customer_id") UUID customerId, @RequestHeader("Authorization") String token) throws Exception
    {
        tokenValidation.isTokenValid(token ,customerId);
       return invoiceService.generateInvoice(customerId);
    }


    @GetMapping("/payment/receipt/{customer_id}")
    public ReceiptDTO getReceipt(@PathVariable("customer_id") UUID customerId, @RequestHeader("Authorization") String token) throws Exception
    {
        tokenValidation.isTokenValid(token ,customerId);


        ReceiptDTO receiptDTO = receiptService.generateReceipt(customerId);



        return receiptDTO;
    }
//    @GetMapping("/payment/receiptv2/{customerId}")
//    public ReceiptDTO getReceipt(@PathVariable("customerId") UUID customerId, @RequestHeader("Authorization") String token) throws Exception
//    {
//        tokenValidation.isTokenValid(token ,customerId);
//
//
//        ReceiptDTO receiptDTO = receiptService.generateReceipt(customerId);
//
//
//
//        return receiptDTO;
//    }


}
