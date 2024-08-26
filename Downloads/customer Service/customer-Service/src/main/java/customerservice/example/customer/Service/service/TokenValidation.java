package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dao.CustomerDao;
import customerservice.example.customer.Service.entity.Customer;
import customerservice.example.customer.Service.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
public class TokenValidation {
    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int TOKEN_LENGTH = 32; // Define a fixed token length

    private final CustomerDao customerDao;

    @Autowired
    public TokenValidation(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    // Generate a secure token
    public String generateToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(TOKEN_LENGTH);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int index = random.nextInt(ALPHANUMERIC_STRING.length());
            sb.append(ALPHANUMERIC_STRING.charAt(index));
        }

        return sb.toString();
    }
    public Optional<UUID> getCustomerIdFromToken(String token) {
        // Decode and parse the token to extract customer information
        // This example assumes the token contains customer ID
        try {
            // Simulate token parsing (you should replace this with your actual token parsing logic)
            // For example, you might decode a JWT token or parse a custom token format
            UUID customerId = decodeTokenToGetCustomerId(token);
            return Optional.of(customerId);
        } catch (Exception e) {
            // Handle exceptions (e.g., token parsing errors)
            return Optional.empty();
        }
    }
    private UUID decodeTokenToGetCustomerId(String token) {
        // This is a placeholder for actual token decoding logic
        // For example, if using JWT, you would parse the token and extract claims
        // Example: return UUID.fromString(token);  // Adjust according to your token structure

        // Assuming token is in the format "customerId:UUID"
        String[] parts = token.split(":");
        if (parts.length == 2) {
            return UUID.fromString(parts[1]);
        }
        throw new IllegalArgumentException("Invalid token format");
    }

    // Validate token
    public boolean isTokenValid(String token , UUID userID) throws Exception{
        Customer customer=customerDao.findById(userID);
        if(Objects.isNull(customer)||!token.equalsIgnoreCase(customer.getToken())){
            throw new RuntimeException("User not found, Invalid token and user id.");
        }
        return true;
    }
}
