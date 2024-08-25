package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public interface CustomerRepository extends JpaRepository  <Customer , UUID> {
    Optional<Customer> findByEmail(String email);
     Optional<Customer> findByToken(String token);
}
