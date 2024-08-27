package customerservice.example.customer.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckoutResponseDTO {
    private double totalAmmount;
    private UUID orderId ;
}
