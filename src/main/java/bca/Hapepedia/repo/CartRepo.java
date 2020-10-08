package bca.Hapepedia.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;

public interface CartRepo extends PagingAndSortingRepository<Cart, Long>{
	public Iterable<Cart> findAllByCustomer(Customer customer);
}
