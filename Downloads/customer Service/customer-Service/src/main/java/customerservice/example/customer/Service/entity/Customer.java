package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    @NotBlank (message = "First name is mandatory")
    @Size (max = 25 , message =  "First name cannot be longer than 25 characters")
    private String firstName;

    @Column(name = " last_name")
    @Size (max = 50 , message =  "First name cannot be longer than 50 characters")
    private String lastName;

    @Column(name = " email" , unique = true)
    @NotBlank (message = "Email is mandatory")
    @Email(message = "Email should be valid ")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password should be at least 6 characters long")
    private String password;

    @OneToOne(mappedBy = "customer" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

//    @OneToMany(mappedBy = "customer")
//    private List<OrderHistory> orderHistory;

    private String token;

    private LocalDateTime tokenExpiration;

}

