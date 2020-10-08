package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.ShippingAddress;

public interface ShippingAddressRepo extends PagingAndSortingRepository<ShippingAddress, Long> {
	
	public Iterable<ShippingAddress> findAllByCustomer(Customer customer);
	
	public Optional<ShippingAddress> findById(Long id);
}
