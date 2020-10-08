package bca.Hapepedia.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import bca.Hapepedia.entity.ShippingFee;

public interface ShippingFeeRepo extends PagingAndSortingRepository<ShippingFee, Integer>
{
    public List<ShippingFee> findByShippingAgencyId(int shippingAgencyId);
    public List<ShippingFee> findByCityId(int cityId);
}
