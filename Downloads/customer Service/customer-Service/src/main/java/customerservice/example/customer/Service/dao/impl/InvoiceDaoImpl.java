package customerservice.example.customer.Service.dao.impl;

import customerservice.example.customer.Service.dao.InvoiceDao;
import customerservice.example.customer.Service.entity.Invoice;
import customerservice.example.customer.Service.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {
    private InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceDaoImpl (InvoiceRepository invoiceRepository)
    {
        this.invoiceRepository = invoiceRepository;
    }
    @Override
    public Invoice saveInvoice(Invoice invoice) {
       return invoiceRepository.save(invoice);

    }
}
