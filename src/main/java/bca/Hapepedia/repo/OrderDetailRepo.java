package bca.Hapepedia.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.OrderDetail;

public interface OrderDetailRepo extends PagingAndSortingRepository<OrderDetail, Integer>{
    public Iterable<OrderDetail> findAllByOrder(int orderId);
}
