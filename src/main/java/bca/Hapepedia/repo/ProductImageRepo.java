package bca.Hapepedia.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import bca.Hapepedia.entity.ProductImage;
public interface ProductImageRepo extends JpaRepository<ProductImage, Long> {
	@Query(value = "SELECT * FROM tb_product_image img, tb_product_detail det WHERE img.product_id = det.product_id AND img.main = 1", nativeQuery = true)
	public Iterable<ProductImage> productShowcase();

	public Iterable<ProductImage> findAllByProductId(Long productId);

	public Iterable<ProductImage> findByMainTrue();
}
