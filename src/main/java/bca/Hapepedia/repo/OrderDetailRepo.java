package bca.Hapepedia.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.OrderDetail;

public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail, Long>{
    public List<OrderDetail> findAllByOrder(Order order);
    public Optional<OrderDetail> findById(Long idOrder);
}
