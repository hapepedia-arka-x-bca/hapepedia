package bca.Hapepedia.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.ProductTag;
import bca.Hapepedia.entity.Tag;

public interface ProductTagRepo extends CrudRepository<ProductTag, Long> {
    public List<Product> findByTag(Tag tag);

    public List<Tag> findByProduct(Product product);
}
