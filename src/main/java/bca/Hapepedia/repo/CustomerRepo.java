package bca.Hapepedia.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Customer;

public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {
    public List<Customer> findByEmail(String email);

    public Optional<Customer> findById(Long id);
}
