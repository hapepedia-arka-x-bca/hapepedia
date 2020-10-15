package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Cart;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.ProductDetail;

public interface CartRepo extends PagingAndSortingRepository<Cart, Long>{
	public Iterable<Cart> findAllByCustomer(Optional<Customer> optional);
	public Iterable<Cart> findAllByCustomer(Customer customer);
	public Optional<Cart> findByProductDetailAndCustomer(ProductDetail productDetail, Customer customer);
}
