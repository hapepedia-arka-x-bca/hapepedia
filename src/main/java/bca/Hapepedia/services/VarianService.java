package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Varian;
import bca.Hapepedia.repo.VarianRepo;

@Service("VarianService")
@Transactional
public class VarianService {
    
    @Autowired
    private VarianRepo varianRepo;

    public Varian save(Varian varian)
    {
        return varianRepo.save(varian);
    }

    public boolean delete(int id)
    {
        varianRepo.deleteById(id);
        return true;
    }

    public List<Varian> findAll(int pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return varianRepo.findAll(pageable).getContent();
    }

    public Optional<Varian> findById(Integer id)
    {
        
        return varianRepo.findById(id);
    }

    public Iterable<Varian> findAllByCategory (long categoryId)
    {
        return varianRepo.findByCategoryId(categoryId);
    }
}
