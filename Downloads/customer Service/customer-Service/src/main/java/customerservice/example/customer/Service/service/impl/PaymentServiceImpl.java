package customerservice.example.customer.Service.service.impl;

import customerservice.example.customer.Service.dao.CartDao;
import customerservice.example.customer.Service.dao.InvoiceDao;
import customerservice.example.customer.Service.dao.PaymentDao;
import customerservice.example.customer.Service.dto.PaymentDTO;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.Invoice;
import customerservice.example.customer.Service.entity.Payment;
import customerservice.example.customer.Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
    public class PaymentServiceImpl implements PaymentService {


        private PaymentDao paymentDao;
        private CartDao cartDao ;
        private InvoiceDao invoiceDao;


        @Autowired
        public  PaymentServiceImpl (PaymentDao paymentDao , CartDao cartDao , InvoiceDao invoiceDao)
        {
            this.paymentDao = paymentDao ;
            this.cartDao   = cartDao ;
            this.invoiceDao = invoiceDao;
        }




//    @Override
//    public String processPayment(PaymentDTO paymentDTO) {
//
//        if (paymentDTO.getCustomerId() == null) {
//            return "Customer ID is required";
//        }
//
//        Payment payment = new Payment();
//        payment.setCustomerId(paymentDTO.getCustomerId());
//        payment.setCardNumber(paymentDTO.getCardNumber());
//        payment.setCvv(paymentDTO.getCvv());
//        payment.setExpiryDate(paymentDTO.getExpiryDate());
//        payment.setAmount(paymentDTO.getAmount());
//        payment.setPaymentDate(paymentDTO.getPaymentDate() != null ? paymentDTO.getPaymentDate() : LocalDateTime.now());
//
//
//        paymentDao.savePayment(payment);
//
//        return "Payment processed successfully";
//    }
//    }



@Override
public String processPayment(PaymentDTO paymentDTO) {

    if (paymentDTO.getCustomerId() == null) {
        return "Customer ID is required";
    }

    Cart  cart = cartDao.findCartByCustomerId(paymentDTO.getCustomerId());
    if (cart == null)
        return "cart Not found for thr given Customer Id";

    Payment payment = new Payment();
    payment.setCustomerId(paymentDTO.getCustomerId());
    payment.setCardNumber(paymentDTO.getCardNumber());
    payment.setCvv(paymentDTO.getCvv());
    payment.setExpiryDate(paymentDTO.getExpiryDate());
    payment.setAmount(paymentDTO.getAmount());
    payment.setPaymentDate(paymentDTO.getPaymentDate() != null ? paymentDTO.getPaymentDate() : LocalDateTime.now());

      payment.setOrderID(cartDao.findOrderIdByCustomerId(paymentDTO.getCustomerId()));
    paymentDao.savePayment(payment);


    Invoice invoice = new Invoice();
    invoice.setCustomerId(paymentDTO.getCustomerId());
    invoice.setInvoiceDate(payment.getPaymentDate());
    invoice.setTotalAmount(payment.getAmount());
    String invoiceNumber = generateInvoiceNumber();
    invoice.setInvoice_Number(invoiceNumber);
    Invoice savedInvoice = invoiceDao.saveInvoice(invoice);


   // return "Payment processed successfully";
    return savedInvoice.getId().toString();
}
    private String generateInvoiceNumber() {

        return "INV-" + System.currentTimeMillis();
    }
    }



