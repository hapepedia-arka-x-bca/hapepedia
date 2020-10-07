package bca.Hapepedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_shipping_address")
public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	@Column(length = 50, nullable = false)
	private String receiverName;
	
	@Column(length = 255, nullable = false)
	private String addressDetail;
	
	@Column(length = 10, nullable = false)
	private String postalCode;
	
	@ManyToOne
	@JoinColumn(name = "province_id", referencedColumnName = "id")
	private Province province;
	
	@ManyToOne
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
