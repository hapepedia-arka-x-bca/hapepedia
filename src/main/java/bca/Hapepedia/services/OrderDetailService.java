package bca.Hapepedia.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.OrderDetail;
import bca.Hapepedia.repo.OrderDetailRepo;

@Service("orderDetailService")
@Transactional
public class OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public OrderDetail save(OrderDetail orderdetail)
    {
      return orderDetailRepo.save(orderdetail);
    }

    public List<OrderDetail> findAllByOrder(Order order)
    {
        return orderDetailRepo.findAllByOrder(order);
    }

    public boolean delete(Long id) {
      orderDetailRepo.deleteById(id);
      return true;
    }
}
