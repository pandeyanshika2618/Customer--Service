package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReceiptRepository extends JpaRepository<Receipt , UUID> {

}
