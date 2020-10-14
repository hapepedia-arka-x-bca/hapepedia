package bca.Hapepedia.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.dto.ShowcaseDto;
import bca.Hapepedia.entity.ProductImage;

public interface ProductImageRepo extends PagingAndSortingRepository<ProductImage, Long>{
	@Query(value = "SELECT * FROM tb_product_image img, tb_product_detail det WHERE img.product_id = det.product_id AND img.main = 1", nativeQuery = true)
	public Iterable<ProductImage> productShowcase();

	public Iterable<ProductImage> findAllByProductId(Long productId);
}
