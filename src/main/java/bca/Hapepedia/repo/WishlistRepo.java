package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Wishlist;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.ProductDetail;

public interface WishlistRepo extends PagingAndSortingRepository<Wishlist, Long>{
	public Iterable<Wishlist> findAllByCustomer(Optional<Customer> optional);
	public Optional<Wishlist> findByProductDetailAndCustomer(ProductDetail productDetail, Customer customer);
}
