package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Receipt;
import org.springframework.stereotype.Service;

@Service
public interface ReceiptDao {
    Receipt saveReceipt(Receipt receipt);
}
