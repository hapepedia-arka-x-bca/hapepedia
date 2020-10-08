package bca.Hapepedia.repo;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.Tag;

public interface TagRepo extends PagingAndSortingRepository<Tag, Long>{
	public Iterable<Tag> findAll();
	
	public Optional<Tag> findById(Long id);
}
