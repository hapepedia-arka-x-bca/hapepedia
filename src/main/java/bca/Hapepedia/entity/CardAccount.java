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
@Table(name = "tb_card_account")
public class CardAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	@Column(nullable = false, length = 255)
	private String cardNumber;

	@Column(nullable = false)
	private byte expiryMonth;

	@Column(nullable = false)
	private short expiryYear;

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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public byte getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(byte expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public short getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(short expiryYear) {
		this.expiryYear = expiryYear;
	}
	
}
