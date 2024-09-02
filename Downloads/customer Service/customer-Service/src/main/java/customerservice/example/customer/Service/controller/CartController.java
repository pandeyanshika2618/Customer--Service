package customerservice.example.customer.Service.controller;

import customerservice.example.customer.Service.dto.*;
import customerservice.example.customer.Service.service.CartService;
import customerservice.example.customer.Service.service.impl.TokenValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
/**
 * REST Controller to process the Cart requests.
 */
@RestController
public class CartController {

     private final CartService cartService;
    private final TokenValidation tokenValidation;

    @Autowired
    public CartController(CartService cartService, TokenValidation tokenValidation) {
        this.cartService = cartService;
        this.tokenValidation = tokenValidation;
    }




    /**
     * Adds a product to the cart for a specified customer.
     *
     * @param productDTO the product details to be added to the cart
     * @param token the authorization token for validating the request
     * @param userId the ID of the user making the request
     * @return a ResponseEntity with a message indicating success or failure.
     */
    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody ProductDTO productDTO , @RequestHeader("Authorization") String token ,  @RequestHeader("userID") String userId) throws Exception {


        tokenValidation.isTokenValid(token,UUID.fromString(userId));
        UUID customerId = productDTO.getId();
        if (customerId == null) {
            return ResponseEntity.badRequest().body("Customer ID is required");
        }

        cartService.addAllProductsToCart(customerId, productDTO);
        return ResponseEntity.ok("Product added to cart");
    }


    /**
     * To get the order details of a customer
     * @param customerId  the id of the customer whose details we want to get
     * @param token   the token is used for validating the customer
     * @return containing the cart details (if cart is found)
     *
     */

    @GetMapping("/list/{customerId}")
    public ResponseEntity<?> getCart(@PathVariable UUID customerId , @RequestHeader("Authorization") String token ) throws  Exception {
        tokenValidation.isTokenValid(token , customerId);
        CartDTO cartDTO = cartService.getCart(customerId);
        if (cartDTO != null) {
            return ResponseEntity.ok(cartDTO);
        } else {
            return ResponseEntity.status(404).body("Cart not found");
        }
    }


    /**
     * To proceed the order request(saving address ).
     * @param customerId the id for which we are making order.
     * @param addressDTO the address of the customer with details such as street , pincode and state etc .
     * @param token   the token is used for validating the customer.
     * @return string response as a string to confirm the order has been placed successfully or not and to get details of the placed order.
     *
     */
    @PostMapping("/checkout/{customerId}")
    public ResponseEntity<String> checkoutCart(@PathVariable UUID customerId, @RequestBody AddressDTO addressDTO ,@RequestHeader("Authorization") String token ) throws Exception{

        tokenValidation.isTokenValid(token , customerId);

        CheckoutResponseDTO response = cartService.checkoutCart(customerId, addressDTO);
        if (response != null && response.getOrderId() != null) {
            String successMessage = String.format("Your Order has been placed . \nOrder ID: %s, \nTotal amount: %.2f",
                    response.getOrderId(), response.getTotalAmmount());
            return ResponseEntity.ok(successMessage);
        }

        return ResponseEntity.status(400).body("Failed to checkout cart");
    }

}
