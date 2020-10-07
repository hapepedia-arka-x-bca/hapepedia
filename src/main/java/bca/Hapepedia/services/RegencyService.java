package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Regency;
import bca.Hapepedia.repo.RegencyRepo;

@Service("regencyService")
@Transactional
public class RegencyService {

    @Autowired
    RegencyRepo regencyRepo;

    public Regency save(Regency regency) {
        return regencyRepo.save(regency);
    }

    public Regency update(Regency regency) {
        return regencyRepo.save(regency);
    }

    public Iterable<Regency> findAll() {
        return regencyRepo.findAll();
    }

    public List<Regency> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return regencyRepo.findAll(pageable).getContent();
    }

    public Optional<Regency> findById(Long id) {
        return regencyRepo.findById(id);
    }

    public Optional<Regency> findByName(String name) {
        return regencyRepo.findByName(name);
    }

    public boolean delete (Long id){
        regencyRepo.deleteById(id);
        return true;
    }
}
