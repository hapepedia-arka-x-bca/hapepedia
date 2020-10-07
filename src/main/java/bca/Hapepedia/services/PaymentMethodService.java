package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.PaymentMethod;
import bca.Hapepedia.repo.PaymentMethodRepo;

@Service("paymentMethodService")
@Transactional
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepo paymentMethodRepo;

    public PaymentMethod save(PaymentMethod paymentMethod) {
        return paymentMethodRepo.save(paymentMethod);
    }

    public PaymentMethod update(PaymentMethod paymentMethod) {
        return paymentMethodRepo.save(paymentMethod);
    }

    public Iterable<PaymentMethod> findAll() {
        return paymentMethodRepo.findAll();
    }

    public List<PaymentMethod> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return paymentMethodRepo.findAll(pageable).getContent();
    }

    public Optional<PaymentMethod> findById(Long id) {
        return paymentMethodRepo.findById(id);
    }

    public Optional<PaymentMethod> findByName(String name) {
        return paymentMethodRepo.findByName(name);
    }

    public boolean delete (Long id){
        paymentMethodRepo.deleteById(id);
        return true;
    }
}
