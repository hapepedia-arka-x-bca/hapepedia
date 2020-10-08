package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Brand;

public interface BrandRepo extends PagingAndSortingRepository<Brand, Long>{
	public Iterable<Brand> findAll();
	
	public Optional<Brand> findById(Long id);
	
}
