package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.dto.CartDTO;
import customerservice.example.customer.Service.dto.CheckoutRequestDTO;
import customerservice.example.customer.Service.dto.OrderDTO;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.OrderHistory;

import java.util.List;
import java.util.UUID;

public class OrderHistoryDaoImpl implements  OrderHistoryDao{

    @Override
    public String checkout() {
        return "";
    }

    @Override
    public String addToCart(OrderHistory orderHistory) {
        return "";
    }

    @Override
    public Cart getCartBYCustomerId(UUID id) {
        return null;
    }

    @Override
    public List<OrderHistory> getOrdersdetailsByCustomerId(UUID id) {
        return List.of();
    }
}
