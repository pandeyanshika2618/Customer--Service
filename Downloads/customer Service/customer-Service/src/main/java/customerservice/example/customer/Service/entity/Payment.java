package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(nullable = false)
    private String expiryDate;
    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;
}
