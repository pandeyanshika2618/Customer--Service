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

/**
 * REST controller to process payment requests.
 */
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

    /**
     *
     * @param paymentDTO the data transfer object contains payment details such as cardNumber , cvv etc.
     * @param token   for validating the customer.
     * @param userId   the id for which we are making payment
     * @return  String   the response signifies the payment is successful or not .
     */
    @PostMapping("/payment/process")
    public ResponseEntity<String> processPayment(@Valid @RequestBody PaymentDTO paymentDTO , @RequestHeader("Authorization") String token , @RequestHeader("UserId") String userId)throws Exception{

        tokenValidation.isTokenValid(token , UUID.fromString(userId));
        String invoiceId = paymentService.processPayment(paymentDTO);
       // String response = paymentService.processPayment(paymentDTO);
       // return ResponseEntity.ok(response);
        return ResponseEntity.ok("Payment done successfully. Invoice ID: " + invoiceId);
    }



    /**
     * Generating invoice for placedorder
     * @param customerId  the id for which the order is placed.
     * @param token        for validating the customer.
     * @return InvoiceDTO  invoice data transfer object containg information about the quantity , price and details about the cart.

     * */

   @GetMapping("/payment/invoice/{customer_id}")
    public InvoiceDTO getInvoice(@PathVariable("customer_id") UUID customerId, @RequestHeader("Authorization") String token) throws Exception
    {
        tokenValidation.isTokenValid(token ,customerId);
       return invoiceService.generateInvoice(customerId);
    }



    /**

     * Generating receipt fot payment
     * @param customerId the id by which payment is intiated.
     * @param token   the validation of the customers.
     * @return  ReceiptDTO as response it has the payment amount , quantity etc

     */
    @GetMapping("/payment/receipt/{customer_id}")
    public ReceiptDTO getReceipt(@PathVariable("customer_id") UUID customerId, @RequestHeader("Authorization") String token) throws Exception
    {
        tokenValidation.isTokenValid(token ,customerId);


        ReceiptDTO receiptDTO = receiptService.generateReceipt(customerId);



        return receiptDTO;
    }



}
