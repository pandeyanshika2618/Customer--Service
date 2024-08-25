package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface CartRepository extends JpaRepository<Cart, UUID> {
   Cart findByCustomerId( UUID customerId);


}
