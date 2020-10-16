package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.ProductDetail;
import bca.Hapepedia.repo.CartRepo;

@Service("cartService")
@Transactional
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;

	public Iterable<Cart> findAllByCustomer (Optional<Customer> optional) {
		return cartRepo.findAllByCustomer(optional);}
	
	public Iterable<Cart> findAllByCustomer (Customer customer) {
		return cartRepo.findAllByCustomer(customer);
	}
	
	public Optional<Cart> findById (Long id) {
		return cartRepo.findById(id);
	}

	public Optional<Cart> findByProductDetailAndCustomer (ProductDetail productDetail, Customer customer) {
		return cartRepo.findByProductDetailAndCustomer(productDetail,customer);
	}
	
	public Cart save(Cart cart) {
		return cartRepo.save(cart);
	}
	
	public boolean delete(Long id) {
		cartRepo.deleteById(id);
		return true;
	}
}
