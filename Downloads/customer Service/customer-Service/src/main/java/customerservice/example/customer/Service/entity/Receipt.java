package customerservice.example.customer.Service.entity;

import jakarta.persistence.*;
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
@Table(name = "receipts")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "receipt_date")
    private LocalDateTime receiptDate;

    @Column(name = "amount")
    private Double amount;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
