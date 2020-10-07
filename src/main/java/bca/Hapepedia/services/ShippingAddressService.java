package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.ShippingAddress;
import bca.Hapepedia.repo.ShippingAddressRepo;

@Service("shippingAddressService")
@Transactional
public class ShippingAddressService {
	@Autowired
	private ShippingAddressRepo shippingAddressRepo;
	
	public Iterable<ShippingAddress> findAllByCustomer(Customer customer) {
		return shippingAddressRepo.findAllByCustomer(customer);
	}
	
	public Optional<ShippingAddress> findById(Long id) {
		return shippingAddressRepo.findById(id);
	}
	
	public ShippingAddress save(ShippingAddress shippingAddress) {
		return shippingAddressRepo.save(shippingAddress);
	}
	
	public ShippingAddress update(ShippingAddress shippingAddress) {
		return shippingAddressRepo.save(shippingAddress);
	}
	
	public boolean delete(Long id) {
		shippingAddressRepo.deleteById(id);
		return true;
	}
}
