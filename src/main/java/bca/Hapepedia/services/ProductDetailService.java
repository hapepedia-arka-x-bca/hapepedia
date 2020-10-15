package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.ProductDetail;
import bca.Hapepedia.repo.ProductDetailRepo;

@Service("ProductDetailService")
@Transactional
public class ProductDetailService {
	@Autowired
	private ProductDetailRepo productDetailRepo;

	public Optional<ProductDetail> findById(Long productDetailId) {
		return productDetailRepo.findById(productDetailId);
	}

	public List<ProductDetail> findByProduct(Product product) {
		return productDetailRepo.findByProduct(product);
	}

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
