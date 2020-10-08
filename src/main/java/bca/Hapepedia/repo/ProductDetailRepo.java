package bca.Hapepedia.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.ProductDetail;

public interface ProductDetailRepo extends PagingAndSortingRepository<ProductDetail, Long>{
	
	public ProductDetail findByProduct(Product product);

}
