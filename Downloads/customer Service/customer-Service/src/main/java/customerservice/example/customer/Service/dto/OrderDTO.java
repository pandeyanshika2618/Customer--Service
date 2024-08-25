package customerservice.example.customer.Service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private UUID id;
    private LocalDateTime orderDate;
    private UUID customerId;
    private List<ProductDTO> products ;


}
