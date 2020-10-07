package bca.Hapepedia.entity;

import javax.persistence.Entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_shipping_fee")
public class ShippingFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    ShippingAgency shippingAgency;

    @ManyToOne
    City city;

    @Column(length = 10, nullable = false)
    private int shippingfee;

    public ShippingFee() {
    }

    public ShippingFee(int id, ShippingAgency shippingAgency, City city, int shippingfee) {
        this.id = id;
        this.shippingAgency = shippingAgency;
        this.city = city;
        this.shippingfee = shippingfee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ShippingAgency getShippingAgency() {
        return shippingAgency;
    }

    public void setShippingAgency(ShippingAgency shippingAgency) {
        this.shippingAgency = shippingAgency;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getShippingfee() {
        return shippingfee;
    }

    public void setShippingfee(int shippingfee) {
        this.shippingfee = shippingfee;
    } 
}
