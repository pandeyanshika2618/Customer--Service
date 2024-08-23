package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dao.CustomerDao;
import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;
import customerservice.example.customer.Service.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerDao customerDao ;

    @Autowired
    public CustomerServiceImpl (CustomerDao customerDao)
    {
        this.customerDao = customerDao ;
    }
    @Override
    public CustomerResponseDTO registeration(CustomerRegisterDTO customerDTO) {

        Customer customer = registerDtoToEntity(customerDTO);
        Customer  tobeSavedCustomer = customerDao.registerCustomer(customer);

        return customerToResponseDTO(tobeSavedCustomer);
    }

    @Override
    public CustomerResponseDTO login(CustomerLoginDTO customerLoginDTO) {
        Optional<Customer> optionalCustomer = customerDao.findByEmail(customerLoginDTO.getEmail());
        Customer customer = optionalCustomer.orElseThrow(() -> new RuntimeException("Invalid username or password"));
        if (customer == null  || !customer.getPassword().equals(customerLoginDTO.getPassword()))
        {
            throw new RuntimeException("Invalid username or password");
        }
        if(customer.getToken() == null || LocalDateTime.now().isAfter(customer.getTokenExpiration()))
        {
            String token = generateToken();
            LocalDateTime tokenExpiration = LocalDateTime.now().plusHours(1);
            customer.setToken(token);
            customer.setTokenExpiration(tokenExpiration);
            customerDao.loginCustomer(customer);
        }
        return customerToResponseDTO(customer);

    }
    private  String generateToken()
    {
        String alphanumericString = "ABCDEFGHIJKLMNOPQRSTWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();


        for (int i = 0 ; i < alphanumericString.length() ; i++)
        {
            int index
                    = (int)(alphanumericString.length()
                    * Math.random());


            sb.append(alphanumericString
                    .charAt(index));
        }

        return sb.toString();
    }
     private  Customer registerDtoToEntity(CustomerRegisterDTO customerRegisterDTO)
     {
         Customer customer = new Customer();
         customer.setFirstName(customerRegisterDTO.getFirstName());
         customer.setLastName(customerRegisterDTO.getLastName());
         customer.setEmail(customerRegisterDTO.getEmail());
         customer.setPassword(customerRegisterDTO.getPassword());
         return customer;
     }
     private Customer loginDtotoEntity (CustomerLoginDTO customerLoginDTO)
     {
         Customer customer = new Customer();
         customer.setEmail(customerLoginDTO.getEmail());
         customer.setPassword(customerLoginDTO.getPassword());
         return  customer ;

     }
    private CustomerResponseDTO customerToResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getToken(),
                customer.getTokenExpiration()

        );
    }
}

