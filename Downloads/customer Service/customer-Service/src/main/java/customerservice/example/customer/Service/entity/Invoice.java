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
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id ;
    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderHistory orderHistory;

}
