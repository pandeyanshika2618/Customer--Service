package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Address;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CartDao {
    Cart findCartByCustomerId(UUID customerId);

    Cart saveCart(Cart cart);


    void saveCartItem(Product product);

    List<Product> findProductsByCartId(UUID cartId);

    void deleteCartItemsByCartId(UUID cartId);
     void saveAddress(Address address) ;


}
