package customerservice.example.customer.Service.dto;

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
public class ReceiptDTO {
    private UUID orderId;
    private Double amount;
    private LocalDateTime paymentDate;
    private String receiptNumber;

//    private PaymentDTO paymentDTO;
//private AddressDTO billingAddress;
//    private AddressDTO shippingAddress;

}
