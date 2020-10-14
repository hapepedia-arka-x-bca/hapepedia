package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.Payment;
import bca.Hapepedia.repo.PaymentRepo;

@Service("paymentService")
@Transactional
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public Payment save(Payment payment)
    {
        return paymentRepo.save(payment);
    }

    public Iterable<Payment> findAll()
    {
        return paymentRepo.findAll();
    }

    public Optional<Payment> findById(Long id)
    {
        return paymentRepo.findById(id);
    }

    public Optional<Payment> findByOrder(Order order)
    {
        return paymentRepo.findByOrder(order);
    }
}
