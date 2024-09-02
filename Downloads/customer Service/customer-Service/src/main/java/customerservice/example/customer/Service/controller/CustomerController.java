package customerservice.example.customer.Service.controller;

import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;
import customerservice.example.customer.Service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Rest Controller to process  Customer-Operations.
 */
@RestController
public class CustomerController {
    private CustomerService customerService ;

    @Autowired
    public  CustomerController (CustomerService customerService)
    {
          this.customerService = customerService;
    }



     /**
     Registers a new customer using the provided customer details.


      @param  customerRegisterDTO the data transfer Object contains details of the customer to be registered

      @return  CustomerResponseDTO the response object contains  details of registered user such as customerId ,name , email and password.


      */
    @PostMapping("/customers/register")
    public CustomerResponseDTO saveCustomerDetails( @Valid  @RequestBody CustomerRegisterDTO customerRegisterDTO) throws Exception
    {
        return customerService.registeration(customerRegisterDTO);
    }





    /**
     * logs a new customer on the basis of registeration
     * @param customerLoginDTO the data transfer objects contains information of registerd customer such as email and password
     * @return CustomerResponseDTO the  response object  signifies successful customer logging with token generation to access other services.
     *
     */
    @PostMapping("/customers/login")
    public CustomerResponseDTO loginCustomer (@RequestBody CustomerLoginDTO  customerLoginDTO) throws Exception
    {
        return customerService.login(customerLoginDTO);
    }




    /**
     * logout the customer
     * @param customerId for the given customer id it inactivates the logging session
     * @return String  the response as String indicates that we have logged out successfully .
     */
    @PostMapping("/customers/logout/{customer_id}")
    public String logoutCustomer( @PathVariable("customer_id") UUID customerId)
    {
       return customerService.logoutCustomerByID(customerId);

    }


}
