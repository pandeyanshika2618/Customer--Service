package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment , UUID> {

}
