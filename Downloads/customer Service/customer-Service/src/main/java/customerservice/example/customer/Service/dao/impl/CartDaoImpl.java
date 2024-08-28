package customerservice.example.customer.Service.dao.impl;

import customerservice.example.customer.Service.dao.CartDao;
import customerservice.example.customer.Service.entity.Address;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.Product;
import customerservice.example.customer.Service.repo.AddressRepository;
import customerservice.example.customer.Service.repo.CartRepository;
import customerservice.example.customer.Service.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class CartDaoImpl implements CartDao {
    private CartRepository cartRepository ;
    private ProductRepository productRepository;
    private AddressRepository addressRepository;
    @Autowired
    public CartDaoImpl(CartRepository cartRepository , ProductRepository productRepository , AddressRepository addressRepository)
    {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public Cart findCartByCustomerId(UUID customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public Cart saveCart(Cart cart) {
       return  cartRepository.save(cart);
    }

    @Override
    public void saveCartItem(Product product) {
        productRepository.save(product);

    }

    @Override
    public List<Product> findProductsByCartId(UUID cartId) {
        return productRepository.findProductsByCartId(cartId);
    }

    @Override
    public void deleteCartItemsByCartId(UUID cartId) {
        cartRepository.deleteById(cartId);

    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);

    }

    @Override
    public UUID findOrderIdByCustomerId(UUID customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        if (cart == null) {
            throw new RuntimeException("Order ID not found for customer ID: " + customerId);
        }
        return cart.getOrderId();
    }
}
