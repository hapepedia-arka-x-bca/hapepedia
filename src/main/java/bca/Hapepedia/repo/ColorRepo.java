package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Color;

public interface ColorRepo extends PagingAndSortingRepository<Color, Long>{
    public Optional<Color> findById(Long id);
}
