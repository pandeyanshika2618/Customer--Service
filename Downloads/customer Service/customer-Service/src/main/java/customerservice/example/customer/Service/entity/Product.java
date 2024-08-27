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

//    @Column (name = "Order_Id")
//    private  UUID  order_id ;
    @Column (name = "quantity")
    private int qunatity ;
    @Column(nullable = false)
    private UUID productId;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
