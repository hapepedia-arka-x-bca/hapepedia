package bca.Hapepedia.services;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import bca.Hapepedia.entity.City;
import bca.Hapepedia.entity.Province;
import bca.Hapepedia.repo.CityRepo;

@Service("cityService")
@Transactional
public class CityService {
    @Autowired
    CityRepo cityRepo;

    public City save(City city) {
        return cityRepo.save(city);
    }

    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }
    
    public Iterable<City> findAllByProvince(Province province){
    	return cityRepo.findAllByProvince(province);
    }
}
