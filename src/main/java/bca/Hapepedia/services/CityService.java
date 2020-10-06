package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.City;
import bca.Hapepedia.repo.CityRepo;

@Service("cityService")
@Transactional
public class CityService {
    @Autowired
    private CityRepo cityRepo;

    public City save(City city)
    {
        return cityRepo.save(city);
    }

    public Iterable<City> findAll()
    {
        return cityRepo.findAll();
    }

    public Optional<City> findByID(String id)
    {
        return cityRepo.findById(id);
    }
}
