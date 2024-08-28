package customerservice.example.customer.Service.controller;

import customerservice.example.customer.Service.dto.*;
import customerservice.example.customer.Service.service.CartService;
import customerservice.example.customer.Service.service.impl.TokenValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CartController {

     private final CartService cartService;
    private final TokenValidation tokenValidation;

    @Autowired
    public CartController(CartService cartService, TokenValidation tokenValidation) {
        this.cartService = cartService;

        this.tokenValidation = tokenValidation;
    }



//
//    @PostMapping("/checkout/{customerId}")
//    public ResponseEntity<String> checkoutCart(@PathVariable UUID customerId, @RequestBody AddressDTO addressDTO ) {
//
//        CheckoutResponseDTO response = cartService.checkoutCart(customerId, addressDTO);
//        if (response != null) {
//            return ResponseEntity.ok("Cart checked out successfully. Total amount: " + response.getTotalAmmount());
//        }
//        return ResponseEntity.status(400).body("Failed to checkout cart");
//    }
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
