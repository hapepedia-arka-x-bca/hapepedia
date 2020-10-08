package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import bca.Hapepedia.entity.Customer;

public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {
    public Customer findByEmail(@Param("title") String email);

    public Optional<Customer> findById(Long id);
}
