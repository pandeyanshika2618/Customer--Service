package customerservice.example.customer.Service.service.impl;

import customerservice.example.customer.Service.dao.CustomerDao;
import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;
import customerservice.example.customer.Service.entity.Customer;
import customerservice.example.customer.Service.exceptionHandler.InvalidCredentialsException;
import customerservice.example.customer.Service.exceptionHandler.RegisterationDuplicacyException;
import customerservice.example.customer.Service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    private TokenValidation tokenValidation;
    private PasswordEncoder passwordEncoder ;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, TokenValidation tokenValidation , PasswordEncoder passwordEncoder) {
        this.customerDao = customerDao;
        this.tokenValidation = tokenValidation;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public CustomerResponseDTO registeration(CustomerRegisterDTO customerDTO) {
//
//        Customer customer = registerDtoToEntity(customerDTO);
//        Customer tobeSavedCustomer = customerDao.registerCustomer(customer);
//
//        return customerToResponseDTO(tobeSavedCustomer);
//    }

//    @Override
//    public CustomerResponseDTO login(CustomerLoginDTO customerLoginDTO) {
//        Optional<Customer> optionalCustomer = customerDao.findByEmail(customerLoginDTO.getEmail());
//        Customer customer = optionalCustomer.orElseThrow(() -> new InvalidDnDOperationException("Invalid username or password"));
//        if (customer == null || !customer.getPassword().equals(customerLoginDTO.getPassword())) {
//            //throw new RuntimeException("Invalid username or password");
//            throw new InvalidCredentialsException("Invalid username and password");
//        }
//        if (customer.getToken() == null || LocalDateTime.now().isAfter(customer.getTokenExpiration())) {
//            String token = tokenValidation.generateToken();
//            LocalDateTime tokenExpiration = LocalDateTime.now().plusHours(1);
//            customer.setToken(token);
//            customer.setTokenExpiration(tokenExpiration);
//            customerDao.loginCustomer(customer);
//            customerDao.registerCustomer(customer);
//
//        }
//        return customerToResponseDTO(customer);
//
//    }

    private Customer registerDtoToEntity(CustomerRegisterDTO customerRegisterDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerRegisterDTO.getFirstName());
        customer.setLastName(customerRegisterDTO.getLastName());
        customer.setEmail(customerRegisterDTO.getEmail());
        customer.setPassword(customerRegisterDTO.getPassword());
        return customer;
    }

    private Customer loginDtotoEntity(CustomerLoginDTO customerLoginDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerLoginDTO.getEmail());
        customer.setPassword(customerLoginDTO.getPassword());
        return customer;

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
    @Override
    public CustomerResponseDTO login(CustomerLoginDTO customerLoginDTO) throws InvalidCredentialsException {
        Optional<Customer> optionalCustomer = customerDao.findByEmail(customerLoginDTO.getEmail());
        Customer customer = optionalCustomer.orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

//        if (!customer.getPassword().equals(customerLoginDTO.getPassword())) {
//            throw new InvalidCredentialsException("Invalid username or password");
//        }
        if (!passwordEncoder.matches(customerLoginDTO.getPassword(), customer.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        if (customer.getToken() == null || LocalDateTime.now().isAfter(customer.getTokenExpiration())) {
            String token = tokenValidation.generateToken();
            LocalDateTime tokenExpiration = LocalDateTime.now().plusHours(1);
            customer.setToken(token);
            customer.setTokenExpiration(tokenExpiration);
            customerDao.loginCustomer(customer);
            customerDao.registerCustomer(customer);
        }

        return customerToResponseDTO(customer);
    }

    @Override
    public String logoutCustomerByID(UUID customerID) {

       tokenValidation.invaliDateToken(customerID);
       return " You are loggedOut!! ";
    }
    @Override
    public CustomerResponseDTO registeration(CustomerRegisterDTO customerDTO) {
        if (customerDao.existByEmail(customerDTO.getEmail()))
        {
            throw new RegisterationDuplicacyException("This email is already in use");
        }
        Customer customer = registerDtoToEntity(customerDTO);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer tobeSavedCustomer = customerDao.registerCustomer(customer);

        return customerToResponseDTO(tobeSavedCustomer);
    }



}

