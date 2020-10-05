package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.Admin;
import bca.Hapepedia.repo.AdminRepo;

@Service("adminService")
@Transactional
public class AdminService {

    @Autowired
    AdminRepo adminRepo;

    public Admin save(Admin admin) {
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

    public Admin login(String email,String password){
        Admin admin = adminRepo.findByEmail(email).get(0);

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
