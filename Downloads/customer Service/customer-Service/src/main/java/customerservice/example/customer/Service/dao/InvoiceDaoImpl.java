package customerservice.example.customer.Service.dao;

import customerservice.example.customer.Service.entity.Invoice;
import customerservice.example.customer.Service.repo.InvoiceRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDaoImpl implements  InvoiceDao {
    private InvoiceRepository invoiceRepository;
    @Override
    public Invoice saveInvoice(Invoice invoice) {
       return invoiceRepository.save(invoice);

    }
}
