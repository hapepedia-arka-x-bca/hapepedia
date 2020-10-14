package bca.Hapepedia.services;

import java.util.Optional;

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

	public Iterable<Cart> findAllByCustomer (Optional<Customer> optional) {
		return cartRepo.findAllByCustomer(optional);
	}
	
	public Cart save(Cart cart) {
		return cartRepo.save(cart);
	}
	
	public boolean delete(Long id) {
		cartRepo.deleteById(id);
		return true;
	}
}
