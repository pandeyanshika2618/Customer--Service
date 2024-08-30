package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, UUID> {
}
