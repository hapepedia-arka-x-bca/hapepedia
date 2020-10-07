package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.repo.CityRepo;

import bca.Hapepedia.entity.City;

@Service("CityService")
@Transactional
public class CityService {
    @Autowired
    CityRepo cityRepo;
    public City save(City city)
    {
        return cityRepo.save(city);
    }
}
