package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;
import customerservice.example.customer.Service.exceptionHandler.InvalidCredentialsException;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerResponseDTO registeration(CustomerRegisterDTO customerDTO);
    CustomerResponseDTO login(CustomerLoginDTO customerLoginDTO) throws InvalidCredentialsException;
    String logoutCustomerByID (UUID customerID);
}
