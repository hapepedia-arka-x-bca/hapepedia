package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;

public interface CartRepo extends PagingAndSortingRepository<Cart, Long>{
	public Iterable<Cart> findAllByCustomer(Optional<Customer> optional);
}
