package customerservice.example.customer.Service.controller;

import customerservice.example.customer.Service.dto.CartDTO;
import customerservice.example.customer.Service.dto.CheckoutRequestDTO;
import customerservice.example.customer.Service.dto.OrderDTO;
import customerservice.example.customer.Service.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrdersController {

    private OrderHistoryService orderHistoryService;

    @Autowired
    public OrdersController(OrderHistoryService orderHistoryService) {
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping("/orders/{customerId")
    public List<OrderDTO> getOrdersdetailsByCustomerId(@PathVariable UUID id) {

    }

    @GetMapping("/orders/cart/{customer-Id}")
    public CartDTO getCartBYCustomerId(@PathVariable UUID id)
    {

    }


   @PostMapping("/Orders/addTocart")
    public String addTocart (@RequestBody OrderDTO orderDTO)
   {

   }

   @PostMapping ("/orders/checkout/{customer_id}")
    public String CheckOut (@RequestBody CheckoutRequestDTO checkoutRequestDTO)
   {

   }

}
