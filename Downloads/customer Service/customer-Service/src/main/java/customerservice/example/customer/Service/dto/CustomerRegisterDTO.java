package customerservice.example.customer.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRegisterDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
//    private String token;
//    private LocalDateTime tokenExpiration;
}
