package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerDao {
    Customer  registerCustomer (Customer customer);
    Customer  loginCustomer (Customer customer);
    Optional<Customer> findByEmail(String email);
    Customer findById(UUID id);
     Optional<Customer> findByToken(String token);



}

