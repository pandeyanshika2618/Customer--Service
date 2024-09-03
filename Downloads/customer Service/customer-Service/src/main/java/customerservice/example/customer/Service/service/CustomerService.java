package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;
import customerservice.example.customer.Service.exceptionHandler.InvalidCredentialsException;

import java.util.List;
import java.util.UUID;

/**
 *Service interface for performing operation such as registeration logging and logOut
 */
public interface CustomerService {
    /**
     *
     * @param customerDTO the data transfer object for registeration containg  information about customer.
     * @return CustomerResponseDTO  the response object after registeration
     */
    CustomerResponseDTO registeration(CustomerRegisterDTO customerDTO);

    /**
     *
     * @param customerLoginDTO  the login data transfer object for logging customer including emailid and password.
     * @return CustomerResponseDTO the response object after successfull logging with toekn generation

     */
    CustomerResponseDTO login(CustomerLoginDTO customerLoginDTO) throws InvalidCredentialsException;

    /**
     *
     * @param customerID the Id of the customer who wants to log out .
     * @return String returns a message for logging out user.
     */
    String logoutCustomerByID (UUID customerID);
}
