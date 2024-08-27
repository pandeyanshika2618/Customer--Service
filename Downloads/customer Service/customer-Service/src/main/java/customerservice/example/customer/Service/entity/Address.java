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
@Table(name = "Addresses")
public class Address {
    @Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id ;

    @Column (name = "addressLine1")
    private String addressLine1;

    @Column (name = "addressLine2")
    private String addressLine2;

    @Column(name = "street")
    private String street ;

    @Column (name = "city")
    private String city ;

    @Column (name = "state")
    private  String state ;

    @Column (name = "pinCode")
    private String pinCode ;

    @OneToOne
    @JoinColumn(name = "customer_id ")
    private Customer  customer;


}
