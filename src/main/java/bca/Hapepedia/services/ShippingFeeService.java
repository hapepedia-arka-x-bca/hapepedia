package bca.Hapepedia.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bca.Hapepedia.entity.ShippingFee;
import bca.Hapepedia.repo.ShippingFeeRepo;

@Service("shippingFeeService")
@Transactional
public class ShippingFeeService{
    @Autowired
    private ShippingFeeRepo shippingFeeRepo;

    public ShippingFee save(ShippingFee shippingFee)
    {
        return shippingFeeRepo.save(shippingFee);
    }

    public boolean delete(int id)
    {
        shippingFeeRepo.deleteById(id);
        return true;
    }

    public List<ShippingFee> findAll(int pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber, 8);
        return shippingFeeRepo.findAll(pageable).getContent();
    }

    public List<ShippingFee> findByShippingAgencyId(int shippingAgencyId)
    {
        return shippingFeeRepo.findByShippingAgencyId(shippingAgencyId);
    }

    public Optional<ShippingFee> findById(int id)
    {
        return shippingFeeRepo.findById(id);
    }

    public Iterable<ShippingFee> findByCityId(int cityId)
    {
        return shippingFeeRepo.findByCityId(cityId);
    }
}
