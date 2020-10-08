package bca.Hapepedia.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Tag;
import bca.Hapepedia.repo.TagRepo;

@Service("tagService")
@Transactional
public class TagService {
	@Autowired
	private TagRepo tagRepo;
	
	public Iterable<Tag> findAll(){
		return tagRepo.findAll();
	}
	
	public Optional<Tag> findById(Long id) {
		return tagRepo.findById(id);
	}
	
	public Tag save(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag update(Tag tag) {
		return tagRepo.save(tag);
	}

	public boolean delete(Long id) {
		tagRepo.deleteById(id);
		return true;
	}
}
