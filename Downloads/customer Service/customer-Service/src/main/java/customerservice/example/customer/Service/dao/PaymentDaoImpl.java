package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Payment;
import customerservice.example.customer.Service.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Payment> findByCustomerId(UUID customerId) {

        return paymentRepository.findByCustomerId(customerId);
    }


}

