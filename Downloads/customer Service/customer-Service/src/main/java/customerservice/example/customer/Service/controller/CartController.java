package customerservice.example.customer.Service.controller;

import customerservice.example.customer.Service.dto.*;
import customerservice.example.customer.Service.service.CartService;
import customerservice.example.customer.Service.service.TokenValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CartController {

     private final CartService cartService;
//    private final TokenValidation tokenValidation;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;

    }
    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody ProductDTO productDTO) {

        UUID customerId = productDTO.getId();  // Assuming productDTO has customerId field

        if (customerId == null) {
            return ResponseEntity.badRequest().body("Customer ID is required");
        }

        cartService.addAllProductsToCart(customerId, productDTO);
        return ResponseEntity.ok("Product added to cart");
    }

    @GetMapping("/list/{customerId}")
    public ResponseEntity<?> getCart(@PathVariable UUID customerId) {
        CartDTO cartDTO = cartService.getCart(customerId);
        return cartDTO != null ? ResponseEntity.ok(cartDTO) : ResponseEntity.status(404).body("Cart not found");
    }

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity<String> checkoutCart(@PathVariable UUID customerId, @RequestBody AddressDTO addressDTO) {

        CheckoutResponseDTO response = cartService.checkoutCart(customerId, addressDTO);
        if (response != null) {
            return ResponseEntity.ok("Cart checked out successfully. Total amount: " + response.getTotalAmmount());
        }
        return ResponseEntity.status(400).body("Failed to checkout cart");
    }

}
