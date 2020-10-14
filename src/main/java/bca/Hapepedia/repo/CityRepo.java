package bca.Hapepedia.repo;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bca.Hapepedia.entity.City;
import bca.Hapepedia.entity.Province;

public interface CityRepo extends CrudRepository<City, String>{
	public Iterable<City> findAll();
	
	public Optional<City> findById(Long id);
	
	public Iterable<City> findAllByProvince(Province province);
}
