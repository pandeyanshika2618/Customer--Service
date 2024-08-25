package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressDAO  {
    Address save(Address address);
    Address findById(UUID id);
}
