package bca.Hapepedia.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Admin;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.SalesReport;

public interface SalesReportRepo extends PagingAndSortingRepository<SalesReport, Long> {
    public List<SalesReport> findByCustomer(Customer customer);
    public List<SalesReport> findByOrder(Order order);
    public List<SalesReport> findByAdmin(Admin admin);
    public Optional<SalesReport> findById(Long id);
}
