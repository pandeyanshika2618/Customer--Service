package customerservice.example.customer.Service.controller;


import customerservice.example.customer.Service.dto.InvoiceDTO;
import customerservice.example.customer.Service.dto.PaymentDTO;
import customerservice.example.customer.Service.dto.ReceiptDTO;
import customerservice.example.customer.Service.service.PaymentService;
import customerservice.example.customer.Service.service.TokenValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {

    private PaymentService paymentService ;
    //private TokenValidation tokenValidation

    @Autowired
    public PaymentController(PaymentService paymentService )
    {
        this.paymentService = paymentService;
//        this.tokenValidation = tokenValidation ;
    }

    @PostMapping("/payment/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentDTO paymentDTO) {
        String response = paymentService.processPayment(paymentDTO);
        return ResponseEntity.ok(response);
    }





//    @GetMapping("/payment/invoice/{order_id}")
//    public InvoiceDTO getInvoice(@PathVariable UUID id , @RequestHeader("Authorization") String authHeader)
//    {
//       return paymentService.getInvoice(id);
//    }
//
//    @GetMapping("/payment/receipt/{order_id}")
//    public ReceiptDTO getReceipt(@PathVariable UUID id , @RequestHeader("Authorization") String authHeader)
//    {
//
//
//        return paymentService.getReceipt(id);
//    }


}
