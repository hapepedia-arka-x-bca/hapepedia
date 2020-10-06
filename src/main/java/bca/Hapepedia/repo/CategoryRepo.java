package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Category;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Long> {
    public Optional<Category> findByName(String email);

    public Optional<Category> findById(Long id);
}
