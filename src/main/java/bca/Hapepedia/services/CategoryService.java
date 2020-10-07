package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Category;
import bca.Hapepedia.repo.CategoryRepo;

@Service("categoryService")
@Transactional
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category update(Category category) {
        return categoryRepo.save(category);
    }

    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    public List<Category> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryRepo.findAll(pageable).getContent();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

    public Optional<Category> findByName(String name) {
        return categoryRepo.findByName(name);
    }

    public boolean delete (Long id){
        categoryRepo.deleteById(id);
        return true;
    }
}
