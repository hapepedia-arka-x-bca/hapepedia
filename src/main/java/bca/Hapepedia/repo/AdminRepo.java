package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Admin;

public interface AdminRepo extends PagingAndSortingRepository<Admin, Long> {
    public Admin findByEmail(String email);

    public Optional<Admin> findById(Long id);
}
