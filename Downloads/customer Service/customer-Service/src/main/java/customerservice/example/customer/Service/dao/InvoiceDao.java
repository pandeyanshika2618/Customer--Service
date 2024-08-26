package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDao {
    Invoice saveInvoice(Invoice invoice);
}
