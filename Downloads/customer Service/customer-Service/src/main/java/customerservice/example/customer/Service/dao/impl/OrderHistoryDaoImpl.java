package customerservice.example.customer.Service.dao.impl;


import customerservice.example.customer.Service.dao.OrderHistoryDao;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.OrderHistory;
import customerservice.example.customer.Service.repo.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderHistoryDaoImpl implements OrderHistoryDao {
       private OrderHistoryRepository orderHistoryRepository ;

       @Autowired
       public OrderHistoryDaoImpl(OrderHistoryRepository orderHistoryRepository)
       {
           this.orderHistoryRepository = orderHistoryRepository;
       }


    @Override
    public String checkout() {
        return "";
    }

    @Override
    public String addToCart(OrderHistory orderHistory) {
        orderHistoryRepository.save(orderHistory);
            return "Item Added Successfully";
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
