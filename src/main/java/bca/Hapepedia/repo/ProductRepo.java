package bca.Hapepedia.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import bca.Hapepedia.entity.Brand;
import bca.Hapepedia.entity.Category;
import bca.Hapepedia.entity.Product;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long>{
	public Iterable<Product> findAll();

	public List<Product> findAllByName(@Param("name") String name, Pageable pageable);
	
	public Iterable<Product> findAllByCategory(Category category);
	
	public Iterable<Product> findAllByBrand(Brand brand);
}
