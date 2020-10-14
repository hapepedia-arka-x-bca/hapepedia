package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Admin;
import bca.Hapepedia.entity.Customer;
import bca.Hapepedia.entity.Order;
import bca.Hapepedia.entity.SalesReport;
import bca.Hapepedia.repo.SalesReportRepo;

@Service("salesReportService")
@Transactional
public class SalesReportService {

    @Autowired
    SalesReportRepo salesReportRepo;

    public SalesReport save(SalesReport salesReport) {
        return salesReportRepo.save(salesReport);
    }

    public SalesReport update(SalesReport salesReport) {
        return salesReportRepo.save(salesReport);
    }

    public Iterable<SalesReport> findAll() {
        return salesReportRepo.findAll();
    }

    public List<SalesReport> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return salesReportRepo.findAll(pageable).getContent();
    }

    public Optional<SalesReport> findById(Long id) {
        return salesReportRepo.findById(id);
    }

    public List<SalesReport> findByCustomer(Customer customer) {
        return salesReportRepo.findByCustomer(customer);
    }

    public List<SalesReport> findByOrder(Order order) {
        return salesReportRepo.findByOrder(order);
    }

    public List<SalesReport> findByAdmin(Admin admin) {
        return salesReportRepo.findByAdmin(admin);
    }

    public boolean delete (Long id){
        salesReportRepo.deleteById(id);
        return true;
    }
}
