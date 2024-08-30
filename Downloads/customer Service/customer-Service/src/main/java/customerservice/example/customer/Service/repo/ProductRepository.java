package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;



public interface ProductRepository  extends JpaRepository<Product, UUID> {
   List<Product> findProductsByCartId(UUID cartid);
   //void deleteByCartId(UUID cartId);


}
