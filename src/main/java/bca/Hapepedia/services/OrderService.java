package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.OrderStatus;
import bca.Hapepedia.repo.OrderRepo;

@Service("orderService")
@Transactional
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public Order update(Order order) {
        return orderRepo.save(order);
    }

    public Iterable<Order> findAll() {
        return orderRepo.findAll();
    }

    public List<Order> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepo.findAll(pageable).getContent();
    }

    public Optional<Order> findById(Long id) {
        return orderRepo.findById(id);
    }

    public List<Order> findByCustomer(Customer customer) {
        return orderRepo.findByCustomer(customer);
    }

    public List<Order> findByOrderStatus(OrderStatus orderStatus) {
        return orderRepo.findByOrderStatus(orderStatus);
    }

    public boolean delete (Long id){
        orderRepo.deleteById(id);
        return true;
    }
}
