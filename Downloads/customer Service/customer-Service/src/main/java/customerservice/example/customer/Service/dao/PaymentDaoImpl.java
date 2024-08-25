package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Payment;
import customerservice.example.customer.Service.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao{
    private PaymentRepository paymentRepository;
    @Autowired
   public PaymentDaoImpl (PaymentRepository paymentRepository)
    {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
