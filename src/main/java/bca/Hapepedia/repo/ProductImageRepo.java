package bca.Hapepedia.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.ProductImage;

public interface ProductImageRepo extends PagingAndSortingRepository<ProductImage, Long>{
	public Iterable<ProductImage> findAllByProductId(Long productId);
}
