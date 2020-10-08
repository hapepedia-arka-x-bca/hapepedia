package bca.Hapepedia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Admin;
import bca.Hapepedia.repo.AdminRepo;

@Service("adminService")
@Transactional
public class AdminService implements UserDetailsService{

    @Autowired
    AdminRepo adminRepo;

    public Admin save(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin update(Admin admin) {
        return adminRepo.save(admin);
    }

    public Iterable<Admin> findAll() {
        return adminRepo.findAll();
    }

    public List<Admin> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return adminRepo.findAll(pageable).getContent();
    }

    public Optional<Admin> findById(Long id) {
        return adminRepo.findById(id);
    }

    public Admin findByEmail(String email) {
        return adminRepo.findByEmail(email);
    }

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepo.findByEmail(email);
		if(admin == null) {
			throw new UsernameNotFoundException("User not found");
		}else {
			List<String> roles = new ArrayList<>();
			roles.add("ADMIN");
			return new Admin(admin, roles);
		}
    }
    
    public Admin login(String email,String password){
        Admin admin = adminRepo.findByEmail(email);

        if(admin.getPassword().equals(password))
            return admin;
        
        else
            return null;
    }


    public boolean delete (Long id){
        adminRepo.deleteById(id);
        return true;
    }
}
