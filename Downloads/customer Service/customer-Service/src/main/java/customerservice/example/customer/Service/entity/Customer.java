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
@Setter
@Getter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = " last_name")
    private String lastName;

    @Column(name = " email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "customer")
    private Address address;

    @OneToMany(mappedBy = "customer")
    private List<OrderHistory> orderHistory;

    private String token;
    private LocalDateTime tokenExpiration;

}

