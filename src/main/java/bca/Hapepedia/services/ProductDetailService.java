package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.ProductDetail;
import bca.Hapepedia.repo.ProductDetailRepo;

@Service("ProductDetailService")
@Transactional
public class ProductDetailService {
	@Autowired
	private ProductDetailRepo productDetailRepo;

	// public ProductDetail findByProduct(Product product) {
	// 	return productDetailRepo.findByProduct(product);
	// }


	public ProductDetail save(ProductDetail productDetail) {
		return productDetailRepo.save(productDetail);
	}

	public ProductDetail update(ProductDetail productDetail) {
		return productDetailRepo.save(productDetail);
	}
	
	public boolean delete(Long id) {
		productDetailRepo.deleteById(id);
		return true;
	}
}
