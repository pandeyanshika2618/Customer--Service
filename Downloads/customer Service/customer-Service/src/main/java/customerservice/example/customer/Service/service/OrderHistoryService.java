package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.CartDTO;
import customerservice.example.customer.Service.dto.OrderDTO;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.OrderHistory;


import java.util.List;
import java.util.UUID;

public interface OrderHistoryService {
    String checkout(OrderDTO orderDTO);
    String addToCart(OrderDTO orderDTO);
    CartDTO getCartBYCustomerId(UUID id);
    List<OrderDTO> getOrdersdetailsByCustomerId( UUID id);


}
