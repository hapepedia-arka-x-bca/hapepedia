package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.repo.CustomerRepo;

@Service("customerService")
@Transactional
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepo.save(customer);
    }

    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }

    public List<Customer> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customerRepo.findAll(pageable).getContent();
    }

    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    public Customer login(String email,String password){
        Customer customer = customerRepo.findByEmail(email).get(0);

        if(customer.getPassword().equals(password))
            return customer;
        
        else
            return null;
    }


    public boolean delete (Long id){
        customerRepo.deleteById(id);
        return true;
    }
}
