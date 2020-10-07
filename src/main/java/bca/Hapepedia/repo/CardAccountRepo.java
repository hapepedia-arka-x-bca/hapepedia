package bca.Hapepedia.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.CardAccount;
import bca.Hapepedia.entity.Customer;

public interface CardAccountRepo extends PagingAndSortingRepository<CardAccount, Long>{
	
	public List<CardAccount> findAllByCustomer(Customer customer);
}
