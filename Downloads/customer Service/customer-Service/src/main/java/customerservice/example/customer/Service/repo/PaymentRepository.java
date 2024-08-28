package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment , UUID> {
//    @Query("SELECT p FROM Payment p WHERE p.id = :id")
//    Payment findCustomerById(UUID CustomerId);

    List<Payment> findByCustomerId(UUID customerId);
//
}
