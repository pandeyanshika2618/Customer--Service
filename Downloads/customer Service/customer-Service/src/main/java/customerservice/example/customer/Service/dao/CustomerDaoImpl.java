package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Customer;
import customerservice.example.customer.Service.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private CustomerRepository customerRepository ;
    @Autowired
    public CustomerDaoImpl(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer registerCustomer(Customer customer) {
         return customerRepository.save(customer);

    }

    @Override
    public Customer loginCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();

            if (existingCustomer.getPassword().equals(customer.getPassword())) {
                return existingCustomer;
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {
            throw new RuntimeException("Customer not found");
        }

    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer findById(UUID id) {
        Optional<Customer> entity=customerRepository.findById(id);
        if(entity.isEmpty()){
            throw new RuntimeException("User Not found");
        }
        return  entity.isPresent()?entity.get():null;
    }

    @Override
    public Optional<Customer> findByToken(String token) {
        return customerRepository.findByToken(token);

    }



}
