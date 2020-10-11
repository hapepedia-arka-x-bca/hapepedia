package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.OrderStatus;
import bca.Hapepedia.repo.OrderStatusRepo;

@Service("orderStatusService")
@Transactional
public class OrderStatusService {
    @Autowired
    OrderStatusRepo orderStatusRepo;

    public OrderStatus save(OrderStatus orderstatus) {
        return orderStatusRepo.save(orderstatus);
    }

    public boolean delete(int id)
    {
        orderStatusRepo.deleteById(id);
        return true;
    }

    public Iterable<OrderStatus> findAll()
    {
        return orderStatusRepo.findAll();
    }

    public OrderStatus findByOrderStatus(OrderStatus orderStatus)
    {
        return orderStatusRepo.findByOrderstatus(orderStatus);
    }
}
