package bca.Hapepedia.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.OrderStatus;

public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {
    public List<Order> findByCustomer(Customer customer);
    
    public List<Order> findByOrderStatus(OrderStatus orderStatus);

    public Optional<Order> findById(Long id);
}
