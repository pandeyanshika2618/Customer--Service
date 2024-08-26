package customerservice.example.customer.Service.service;

import customerservice.example.customer.Service.dao.InvoiceDao;
import customerservice.example.customer.Service.dao.PaymentDao;
import customerservice.example.customer.Service.dto.InvoiceDTO;
import customerservice.example.customer.Service.entity.Invoice;
import customerservice.example.customer.Service.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    private InvoiceDao invoiceDao ;
    private PaymentDao paymentDao;

    @Autowired
    public InvoiceServiceImpl (InvoiceDao invoiceDao , PaymentDao paymentDao)
    {
        this.invoiceDao = invoiceDao;
        this.paymentDao = paymentDao;
    }
    @Override
    public InvoiceDTO generateInvoice(UUID id) {
        Optional<Payment> optionalPayment = paymentDao.findById(id);


        if (!optionalPayment.isPresent()) {
            throw new RuntimeException("Payment not found for ID: " + id);
        }


        Payment payment = optionalPayment.get();


        Invoice invoice = new Invoice();
        invoice.setOrderId(id);
        invoice.setInvoiceDate(payment.getPaymentDate());
        invoice.setTotalAmount(payment.getAmount());
        Invoice savedInvoice = invoiceDao.saveInvoice(invoice);
        return convertToDTO(savedInvoice);
    }
    private InvoiceDTO convertToDTO(Invoice invoice) {
        InvoiceDTO dto = new InvoiceDTO();
        dto.setId(invoice.getId());
        dto.setOrderId(invoice.getOrderId());
        dto.setAmount(invoice.getTotalAmount());
        dto.setInvoiceDate(invoice.getInvoiceDate());
        dto.setCustomerId(invoice.getCustomerId());
        return dto;
    }

}
