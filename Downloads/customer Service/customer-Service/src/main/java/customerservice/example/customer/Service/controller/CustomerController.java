package customerservice.example.customer.Service.controller;

import customerservice.example.customer.Service.dto.CustomerLoginDTO;
import customerservice.example.customer.Service.dto.CustomerRegisterDTO;
import customerservice.example.customer.Service.dto.CustomerResponseDTO;
import customerservice.example.customer.Service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private CustomerService customerService ;

    @Autowired
    public  CustomerController (CustomerService customerService)
    {
          this.customerService = customerService;
    }

    @PostMapping("/customers/register")
    public CustomerResponseDTO saveCustomerDetails( @Valid  @RequestBody CustomerRegisterDTO customerRegisterDTO)
    {
        return customerService.registeration(customerRegisterDTO);
    }

    @PostMapping("/customers/login")
    public CustomerResponseDTO loginCustomer (@RequestBody CustomerLoginDTO  customerLoginDTO) throws Exception
    {
        return customerService.login(customerLoginDTO);
    }


}
