package customerservice.example.customer.Service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {
    private  UUID id ;
    private UUID customerId;
    private String addressLine1  ;
    private String addressLine2;
    private String street;
    private String city ;
    private String state ;
    @NotBlank(message = "pinCode is mandatory")
    private String pinCode ;
}
