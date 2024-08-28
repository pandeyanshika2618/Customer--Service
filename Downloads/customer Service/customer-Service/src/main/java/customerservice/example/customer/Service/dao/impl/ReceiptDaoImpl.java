package customerservice.example.customer.Service.dao.impl;

import customerservice.example.customer.Service.dao.ReceiptDao;
import customerservice.example.customer.Service.entity.Receipt;
import customerservice.example.customer.Service.repo.ReceiptRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceiptDaoImpl implements ReceiptDao {

    private ReceiptRepository receiptRepository;
    @Override
    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }
}
