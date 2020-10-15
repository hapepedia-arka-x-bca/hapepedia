package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Wishlist;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.ProductDetail;
import bca.Hapepedia.repo.WishlistRepo;

@Service("wishlistService")
@Transactional
public class WishlistService {
	
	@Autowired
	private WishlistRepo wishlistRepo;

	public Iterable<Wishlist> findAllByCustomer (Optional<Customer> optional) {
		return wishlistRepo.findAllByCustomer(optional);}
	
	public Optional<Wishlist> findById (Long id) {
		return wishlistRepo.findById(id);
	}

	public Optional<Wishlist> findByProductDetailandByCustomer (ProductDetail productDetail, Customer customer) {
		return wishlistRepo.findByProductDetailAndCustomer(productDetail,customer);
	}
	public Wishlist save(Wishlist wishlist) {
		return wishlistRepo.save(wishlist);
	}
	
	public boolean delete(Long id) {
		wishlistRepo.deleteById(id);
		return true;
	}
}
