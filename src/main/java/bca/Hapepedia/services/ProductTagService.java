package bca.Hapepedia.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.ProductTag;
import bca.Hapepedia.entity.Tag;
import bca.Hapepedia.repo.ProductTagRepo;

@Service("productTagService")
@Transactional
public class ProductTagService {

    @Autowired
    ProductTagRepo productTagRepo;

    public ProductTag save(ProductTag productTag) {
        return productTagRepo.save(productTag);
    }

    public ProductTag update(ProductTag productTag) {
        return productTagRepo.save(productTag);
    }

    public List<Product> findByTag(Tag tag) {
        return productTagRepo.findByTag(tag);
    }

    public List<Tag> findByProduct(Product product) {
        return productTagRepo.findByProduct(product);
    }

    public boolean delete (Long id){
        productTagRepo.deleteById(id);
        return true;
    }
}
