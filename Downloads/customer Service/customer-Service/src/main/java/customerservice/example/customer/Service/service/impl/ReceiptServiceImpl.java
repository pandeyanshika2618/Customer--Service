package customerservice.example.customer.Service.service.impl;

import customerservice.example.customer.Service.dao.AddressDAO;
import customerservice.example.customer.Service.dao.PaymentDao;
import customerservice.example.customer.Service.dao.ReceiptDao;
import customerservice.example.customer.Service.dto.ReceiptDTO;
import customerservice.example.customer.Service.entity.Payment;
import customerservice.example.customer.Service.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private ReceiptDao receiptDao ;
    private PaymentDao paymentDao;
    protected AddressDAO addressDAO ;
    @Autowired
    public  ReceiptServiceImpl(ReceiptDao receiptDao , PaymentDao paymentDao , AddressDAO addressDAO)
    {
        this.receiptDao = receiptDao ;
        this.paymentDao = paymentDao;
        this.addressDAO = addressDAO ;
    }
    public ReceiptDTO generateReceipt(UUID customerId) {
       Optional<Payment> optionalPayment = paymentDao.findByCustomerId(customerId);
//        Optional<Payment>  optionalPayment = paymentDao.findById(customerId);


        if (!optionalPayment.isPresent()) {
            throw new RuntimeException("Payment not found for customer ID: " + customerId);
        }


        Payment payment = optionalPayment.get();
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setOrderId(payment.getOrderID());
        receiptDTO.setAmount(payment.getAmount());
        receiptDTO.setPaymentDate(payment.getPaymentDate());
        receiptDTO.setReceiptNumber(generateReceiptNumber());


        return receiptDTO;
    }
    private String generateReceiptNumber() {

        return "REC-" + System.currentTimeMillis();
    }
}
