package bca.Hapepedia.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.ShippingAgency;
import bca.Hapepedia.repo.ShippingAgencyRepo;

@Service("shippingAgencyService")
@Transactional
public class ShippingAgencyService {
    @Autowired
    private ShippingAgencyRepo shippingAgencyRepo;
    public ShippingAgency save(ShippingAgency shippingAgency)
    {
        return shippingAgencyRepo.save(shippingAgency);
    }

    public boolean delete(int id)
    {
        shippingAgencyRepo.deleteById(id);
        return true;
    }

    public Iterable<ShippingAgency> findAll()
    {
        return shippingAgencyRepo.findAll();
    }
}
