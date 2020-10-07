package bca.Hapepedia.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Varian;

public interface VarianRepo extends PagingAndSortingRepository<Varian, Integer>{
    
}
