package bca.Hapepedia.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Varian;

public interface VarianRepo extends PagingAndSortingRepository<Varian, Long>{
    public List<Varian> findByCategoryId(Long categoryId);
}
