package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO registeration(CustomerRegisterDTO customerDTO);
    CustomerResponseDTO login(CustomerLoginDTO customerLoginDTO);
}
