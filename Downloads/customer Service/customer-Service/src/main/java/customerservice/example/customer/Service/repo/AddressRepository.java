package customerservice.example.customer.Service.repo;

import customerservice.example.customer.Service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
