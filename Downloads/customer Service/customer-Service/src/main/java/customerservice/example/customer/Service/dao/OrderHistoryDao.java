package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.OrderHistory;

import java.util.List;
import java.util.UUID;

public interface OrderHistoryDao {
    String checkout();
    String addToCart(OrderHistory orderHistory);
    Cart getCartBYCustomerId(UUID id);
    List<OrderHistory> getOrdersdetailsByCustomerId(UUID id);


}
