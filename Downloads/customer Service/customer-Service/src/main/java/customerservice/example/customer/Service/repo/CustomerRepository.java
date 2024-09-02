package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface CustomerRepository extends JpaRepository  <Customer, UUID> {
    Optional<Customer> findByEmail(String email);
     Optional<Customer> findByToken(String token);
    boolean existsByEmail(String email);
}
