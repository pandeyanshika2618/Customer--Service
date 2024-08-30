package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Payment;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentDao {
     Payment savePayment(Payment payment);
     Optional<Payment> findByCustomerId(UUID customerId);
     //Optional<Payment> findById(UUID customerId);
}

