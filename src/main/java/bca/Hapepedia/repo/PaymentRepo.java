package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Long>{
    public Optional<Payment> findByOrder(Order order);
}
