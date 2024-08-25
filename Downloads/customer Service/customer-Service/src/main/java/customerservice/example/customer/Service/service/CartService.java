package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.*;

import java.util.UUID;

public interface CartService {
    CartDTO addAllProductsToCart(UUID id , ProductDTO productDTO);
    CheckoutResponseDTO checkoutCart(UUID customerId, AddressDTO addressDTO);
    CartDTO getCart(UUID customerId);
    //String checkout (UUID customerId , Check)

}
