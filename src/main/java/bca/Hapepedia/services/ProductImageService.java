package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.dto.ShowcaseDto;
import bca.Hapepedia.entity.ProductImage;
import bca.Hapepedia.repo.ProductImageRepo;

@Service("productImageService")
@Transactional
public class ProductImageService {
	@Autowired
	private ProductImageRepo productImageRepo;
	
	public Iterable<ProductImage> findByMainTrue()
	{
		return productImageRepo.findByMainTrue();
	}
	public Iterable<ProductImage> findAllByProductId(Long productId) {
		return productImageRepo.findAllByProductId(productId);
	}

	public Iterable<ProductImage> productShowcase()
	{
		return productImageRepo.productShowcase();
	}
	
	public Optional<ProductImage> findById(Long id) {
		return productImageRepo.findById(id);
	}
	
	public ProductImage save(ProductImage productImage) {
		return productImageRepo.save(productImage);
	}
	
	public boolean delete(Long id) {
		productImageRepo.deleteById(id);
		return true;
	}
}
