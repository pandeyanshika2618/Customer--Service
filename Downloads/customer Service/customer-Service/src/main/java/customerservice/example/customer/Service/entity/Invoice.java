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

    @Column(name = "invoice_Number")
    private  String invoice_Number ;

    @Column(name = "total_amount")
    private Double totalAmount;

//    @Column(name =  "quantity_of_goods")
//    private Integer quantity ;
//    @Column(name = "order_id", nullable = false)
//    private UUID orderId;
    @Column(name = "customer_id", nullable = false)
    private UUID customerId;











}
