package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dao.PaymentDao;
import customerservice.example.customer.Service.dto.PaymentDTO;
import customerservice.example.customer.Service.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
    public class PaymentServiceImpl implements PaymentService {

        @Autowired
        private PaymentDao paymentDao;




    @Override
    public String processPayment(PaymentDTO paymentDTO) {

        if (paymentDTO.getCustomerId() == null) {
            return "Customer ID is required";
        }

        Payment payment = new Payment();
        payment.setCustomerId(paymentDTO.getCustomerId());
        payment.setCardNumber(paymentDTO.getCardNumber());
        payment.setCvv(paymentDTO.getCvv());
        payment.setExpiryDate(paymentDTO.getExpiryDate());
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate() != null ? paymentDTO.getPaymentDate() : LocalDateTime.now());


        paymentDao.savePayment(payment);

        return "Payment processed successfully";
    }
    }



