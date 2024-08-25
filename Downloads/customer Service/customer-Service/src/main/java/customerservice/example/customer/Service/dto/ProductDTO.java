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
public class ProductDTO {
    private UUID id ;
    private String name ;
    private Double price ;
    private Integer quantity ;





}
