package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.CardAccount;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.repo.CardAccountRepo;

@Service("cardAccountService")
@Transactional
public class CardAccountService {
	
	@Autowired
	private CardAccountRepo cardAccountRepo;
	
	public Iterable<CardAccount> findAllByCustomer(Customer customer) {
		return cardAccountRepo.findAllByCustomer(customer);
	}
	
	public CardAccount findById(Long id) {
		return cardAccountRepo.findById(id).get();
	}
	
	public CardAccount save(CardAccount cardAccount) {
		return cardAccountRepo.save(cardAccount);
	}
	
	public CardAccount update(CardAccount cardAccount) {
		return cardAccountRepo.save(cardAccount);
	}
	
	public boolean delete(CardAccount cardAccount) {
		cardAccountRepo.delete(cardAccount);
		return true;
	}
}
