package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao {
     Payment savePayment(Payment payment) ;

}

