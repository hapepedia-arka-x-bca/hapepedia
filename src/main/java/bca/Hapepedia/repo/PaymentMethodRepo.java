package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.PaymentMethod;

public interface PaymentMethodRepo extends PagingAndSortingRepository<PaymentMethod, Long> {
    public Optional<PaymentMethod> findByName(String email);

    public Optional<PaymentMethod> findById(Long id);
}
