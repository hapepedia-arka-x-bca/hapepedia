package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Regency;

public interface RegencyRepo extends PagingAndSortingRepository<Regency, Long> {
    public Optional<Regency> findByName(String email);

    public Optional<Regency> findById(Long id);
}
