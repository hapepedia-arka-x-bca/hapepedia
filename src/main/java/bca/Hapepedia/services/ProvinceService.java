package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Province;
import bca.Hapepedia.repo.ProvinceRepo;

@Service("provinceService")
@Transactional
public class ProvinceService {
	@Autowired
	private ProvinceRepo provinceRepo;
	
	public Iterable<Province> findAll(){
		return provinceRepo.findAll();
	}
	
	public Optional<Province> findById(Long id) {
		return provinceRepo.findById(id);
	}
	
	public Province save(Province province) {
		return provinceRepo.save(province);
	}
	
	public Province update(Province province) {
		return provinceRepo.save(province);
	}
	
	public boolean delete(Long id) {
		provinceRepo.deleteById(id);
		return true;
	}
}
