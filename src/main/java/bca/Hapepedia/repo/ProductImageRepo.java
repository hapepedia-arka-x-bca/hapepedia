package bca.Hapepedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import bca.Hapepedia.entity.ProductImage;

public interface ProductImageRepo extends JpaRepository<ProductImage, Long>{
	public Iterable<ProductImage> findAllByProductId(Long productId);

	public Iterable<ProductImage> findByMainTrue();
}
