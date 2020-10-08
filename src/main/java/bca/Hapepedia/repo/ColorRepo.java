package bca.Hapepedia.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Color;

public interface ColorRepo extends PagingAndSortingRepository<Color, Integer>{
    
}
