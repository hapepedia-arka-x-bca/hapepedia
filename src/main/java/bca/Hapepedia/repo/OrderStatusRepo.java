package bca.Hapepedia.repo;

import org.springframework.data.repository.CrudRepository;

import bca.Hapepedia.entity.OrderStatus;

public interface OrderStatusRepo extends CrudRepository<OrderStatus, Integer>{
    
}
