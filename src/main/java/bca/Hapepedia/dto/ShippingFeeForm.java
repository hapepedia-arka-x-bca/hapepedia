package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class ShippingFeeForm {
    private int id;
    @NotEmpty(message="Shipping fee is required")
    private int shippingFee;

    @NotEmpty(message="Shipping agency is required")
    private int shippingAgencyId;

    @NotEmpty(message="Destination city is required")
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public int getShippingAgencyId() {
        return shippingAgencyId;
    }

    public void setShippingAgencyId(int shippingAgencyId) {
        this.shippingAgencyId = shippingAgencyId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }    
}
