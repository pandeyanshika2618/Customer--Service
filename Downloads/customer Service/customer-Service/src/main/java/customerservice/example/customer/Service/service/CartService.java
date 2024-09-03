package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dto.*;

import java.util.UUID;

/**
 * Interface for cart servies.
 */
public interface CartService {
    /**
     *
     * @param id
     * @param productDTO the data transfer Object containing information about products such as quantity , price etc.
     * @return  CartDTO   the data transfer  object  as response for saving details in cart.
     */
    CartDTO addAllProductsToCart(UUID id , ProductDTO productDTO);

    /**
     *
     * @param customerId The id of the customer who wants to checkout.
     * @param addressDTO  the data transfer object which is used while checkout for saving address of customer.
     * @return checkoutResponse the  respone agter placing order with confirmation and orderId.
     */
    CheckoutResponseDTO checkoutCart(UUID customerId, AddressDTO addressDTO);

    /**
     *
     * @param customerId id of the customer
     * @return CartDto response as a cart of the customer
     */
    CartDTO getCart(UUID customerId);
    //String checkout (UUID customerId , Check)

}
