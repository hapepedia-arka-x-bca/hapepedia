package bca.Hapepedia.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.OrderDetail;

public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail, Long>{
    public List<OrderDetail> findAllByOrder(Order order);
}
