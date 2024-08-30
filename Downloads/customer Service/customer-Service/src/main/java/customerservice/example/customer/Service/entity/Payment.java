package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;




    @Column(name = "customer_id", nullable = false , unique = true)
    private UUID customerId;

    @Column(name = "order_id")
    private UUID orderID ;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "card_number", nullable = false)
    @NotBlank(message = "cardNumber can't Blank")
    private String cardNumber;

    @Column(name = "cvv", nullable = false)
    @NotBlank (message = "cvv canNot be blank")
    private String cvv;

    @Column(nullable = false)
    private String expiryDate;
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;


}
