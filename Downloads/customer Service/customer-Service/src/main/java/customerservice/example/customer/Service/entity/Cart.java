package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn (name = "customer_id")
    private  Customer customer ;


}
