package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Address;
import customerservice.example.customer.Service.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AddressDaoImpl implements AddressDAO{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);

    }

    @Override
    public Address findById(UUID id) {
        return  addressRepository.findById(id).orElse(null);
    }
}
