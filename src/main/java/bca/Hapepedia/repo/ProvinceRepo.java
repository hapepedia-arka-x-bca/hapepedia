package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Province;

public interface ProvinceRepo extends PagingAndSortingRepository<Province, Long>{
	public Iterable<Province> findAll();
	
	public Optional<Province> findById(Long id);
	
}
