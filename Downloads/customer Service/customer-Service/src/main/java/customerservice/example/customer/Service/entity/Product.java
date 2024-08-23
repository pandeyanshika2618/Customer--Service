package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "Product_List")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id ;

    @Column (name = "names_Of_Product")
    private  String name ;

    @Column (name = "price")
    private  Double price ;

     @ManyToOne
    @JoinColumn(name = "order_id")
    private  OrderHistory orderHistory ;

}
