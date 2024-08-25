package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "orders_History")
public class OrderHistory {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id ;

    @Column (name = "order_date")
    private LocalDateTime orderDate ;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @OneToMany(mappedBy = "orderHistory")
//    private List<Product> products ;

//    @OneToOne (mappedBy = "orderHistory")
//    private  Payment payemnt ;
//
//    @OneToOne (mappedBy =  "orderHistory")
//    private   Invoice invoice ;
//
//    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Address address;

}
