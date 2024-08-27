package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dao.CustomerDao;
import customerservice.example.customer.Service.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
public class TokenValidation {
    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    private static final int TOKEN_LENGTH = 32;

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

        try {

            UUID customerId = decodeTokenToGetCustomerId(token);
            return Optional.of(customerId);
        } catch (Exception e) {

            return Optional.empty();
        }
    }
    private UUID decodeTokenToGetCustomerId(String token) {


        String[] parts = token.split(":");
        if (parts.length == 2) {
            return UUID.fromString(parts[1]);
        }
        throw new IllegalArgumentException("Invalid token format");
    }


    public boolean isTokenValid(String token , UUID userID) throws Exception{
        Customer customer=customerDao.findById(userID);
        if(Objects.isNull(customer)||!token.equalsIgnoreCase(customer.getToken())){
            throw new RuntimeException("User not found, Invalid token and user id.");
        }
        return true;
    }
}
