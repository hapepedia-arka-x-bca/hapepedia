package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Color;
import bca.Hapepedia.repo.ColorRepo;

@Service("ColorService")
@Transactional
public class ColorService {
    @Autowired
    ColorRepo colorRepo;

    public Color save(Color color) {
        return colorRepo.save(color);
    }

    public boolean delete(Long id) {
        colorRepo.deleteById(id);
        return true;
    }

    public List<Color> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return colorRepo.findAll(pageable).getContent();
    }
    
    public Iterable<Color> findAll(){
    	return colorRepo.findAll();
    }
    
    public Optional<Color> findById(Long id) {
        return colorRepo.findById(id);
    }
    
}
