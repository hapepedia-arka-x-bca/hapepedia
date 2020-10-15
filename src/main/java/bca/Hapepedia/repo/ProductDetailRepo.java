package bca.Hapepedia.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.ProductDetail;

public interface ProductDetailRepo extends PagingAndSortingRepository<ProductDetail, Long>{
    public List<ProductDetail> findByProduct(Product product);

    public Optional<ProductDetail> findById(Long id);
}
