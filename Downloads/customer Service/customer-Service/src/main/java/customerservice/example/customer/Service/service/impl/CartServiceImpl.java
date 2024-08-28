package customerservice.example.customer.Service.service.impl;

import customerservice.example.customer.Service.dao.AddressDAO;
import customerservice.example.customer.Service.dao.CartDao;
import customerservice.example.customer.Service.dto.AddressDTO;
import customerservice.example.customer.Service.dto.CartDTO;
import customerservice.example.customer.Service.dto.CheckoutResponseDTO;
import customerservice.example.customer.Service.dto.ProductDTO;
import customerservice.example.customer.Service.entity.Address;
import customerservice.example.customer.Service.entity.Cart;
import customerservice.example.customer.Service.entity.Product;
import customerservice.example.customer.Service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    private CartDao cartDAO ;
    private AddressDAO addressDAO;
//    private ProductDao productDao ;
     @Autowired
     public CartServiceImpl(CartDao cartDAO , AddressDAO addressDAO) {
         this.cartDAO = cartDAO;
         this.addressDAO = addressDAO;

     }





    @Override
    public CartDTO addAllProductsToCart(UUID id, ProductDTO productDTO) {
        Cart cart = cartDAO.findCartByCustomerId(id);
        if (cart == null) {

            cart = new Cart();
            cart.setCustomerId(id);  // Set the customerId here
            cart = cartDAO.saveCart(cart);
        }

        Product product = new Product();
        product.setCart(cart);
        product.setName(productDTO.getName());
        product.setProductId(productDTO.getId());
        product.setQunatity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        cartDAO.saveCartItem(product);

        return toDTO(cart);
    }

    @Override
    public CheckoutResponseDTO checkoutCart(UUID customerId, AddressDTO addressDTO) {
        Cart cart = cartDAO.findCartByCustomerId(customerId);
        if (cart == null) {
            return null;
        }


        List<Product> products = cartDAO.findProductsByCartId(cart.getId());
        if (products.isEmpty()) {
            System.out.println("No products found in cart with ID: " + cart.getId());
        }

        double totalAmount = products.stream()
                .mapToDouble(product -> product.getPrice() * product.getQunatity())
                .sum();


        Address address = new Address();
        address.setId(addressDTO.getCustomerId());
        address.setAddressLine1(addressDTO.getAddressLine1());
        address.setAddressLine2(addressDTO.getAddressLine2());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setPinCode(addressDTO.getPinCode());
        addressDAO.save(address);


      UUID orderID = UUID.randomUUID();
      cart.setOrderId(orderID);
      cartDAO.saveCart(cart);
        return new CheckoutResponseDTO(totalAmount ,orderID );
    }

    @Override
    public CartDTO getCart(UUID customerId) {
        Cart cart = cartDAO.findCartByCustomerId(customerId);
        if (cart == null) {
            System.out.println("Cart not found for customerId: " + customerId);

        }

        List<Product> products = cartDAO.findProductsByCartId(cart.getId());
        if (products.isEmpty()) {
            System.out.println("No products found in cart with ID: " + cart.getId());
        }

        double totalAmount = products.stream()
                .mapToDouble(product -> product.getPrice() * product.getQunatity())
                .sum();


        System.out.println("Total amount for cart ID " + cart.getId() + " is: " + totalAmount);

        List<ProductDTO> productDTOs = products.stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getPrice(), p.getQunatity()))
                .collect(Collectors.toList());

        return new CartDTO(cart.getId(), productDTOs, totalAmount);
    }

//    public CartDTO getCart(UUID customerId) {
//        Cart cart = cartDAO.findCartByCustomerId(customerId);
//        if (cart == null) {
//            return null;
//        }
//    }

//    public boolean checkoutCart(UUID customerId) {
//        Cart cart = cartDAO.findCartByCustomerId(customerId);
//        if (cart == null) {
//            return false;
//
//
//
//    }
        private CartDTO toDTO(Cart cart) {
            List<ProductDTO> items = cartDAO.findProductsByCartId(cart.getId()).stream()
                    .map(product -> {
                        ProductDTO productDTO = new ProductDTO();
                        productDTO.setId(product.getProductId());
                        productDTO.setQuantity(product.getQunatity());
                        return productDTO;
                    })
                    .collect(Collectors.toList());

            CartDTO cartDTO = new CartDTO();
            cartDTO.setId(cart.getId());
            cartDTO.setCustomerId(cart.getId());
            cartDTO.setProducts(items);
            return cartDTO;
        }
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getQunatity());
    }

    }

