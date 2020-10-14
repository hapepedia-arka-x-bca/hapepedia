package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.repo.CartRepo;

@Service("cartService")
@Transactional
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	public Iterable<Cart> findAllByCustomer (Long customerId) {
		return cartRepo.findAllByCustomer(customerId);
	}
	
	public Cart save(Cart cart) {
		return cartRepo.save(cart);
	}
	
	public boolean delete(Long id) {
		cartRepo.deleteById(id);
		return true;
	}
}
