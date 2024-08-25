package customerservice.example.customer.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDTO {
        private UUID id;
        private UUID customerId;
        private List<ProductDTO> products;
       private  Double totalAmount ;
        public CartDTO(UUID id, List<ProductDTO> products, double totalAmount) {
                this.id = id;
                this.products = products;
                this.totalAmount = totalAmount;
        }





}
