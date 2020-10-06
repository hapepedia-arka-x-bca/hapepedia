package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Brand;
import bca.Hapepedia.repo.BrandRepo;

@Service("brandService")
@Transactional
public class BrandService {
	
	@Autowired
	private BrandRepo brandRepo;
	
	public Iterable<Brand> findAll(){
		return brandRepo.findAll();
	}
	
	public Optional<Brand> findById(Long id) {
		return brandRepo.findById(id);
	}
	
	public Brand save(Brand brand) {
		return brandRepo.save(brand);
	}
	
	public Brand update(Brand brand) {
		return brandRepo.save(brand);
	}
	
	public boolean delete (Long id){
        brandRepo.deleteById(id);
        return true;
    }
}
