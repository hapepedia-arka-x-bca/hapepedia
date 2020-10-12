package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Iterable<OrderDetail> findAllByOrder(int orderId)
    {
        return orderDetailRepo.findAllByOrder(orderId);
    }

    public boolean delete(int id) {
      orderDetailRepo.deleteById(id);
      return true;
    }
}
