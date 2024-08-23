package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.CartDTO;
import customerservice.example.customer.Service.dto.CheckoutRequestDTO;
import customerservice.example.customer.Service.dto.OrderDTO;
import customerservice.example.customer.Service.entity.OrderHistory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Override
    public String checkout(CheckoutRequestDTO checkoutRequestDTO) {
        return "";
    }

    @Override
    public String addToCart(OrderDTO orderDTO) {
        return "";
    }

    @Override
    public String checkout(OrderHistory orderHistory) {
        return "";
    }

    @Override
    public String addToCart(OrderHistory orderHistory) {
        return "";
    }

    @Override
    public CartDTO getCartBYCustomerId(UUID id) {
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersdetailsByCustomerId(UUID id) {
        return List.of();
    }
}
