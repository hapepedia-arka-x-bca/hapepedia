package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class CardAccountForm {
	
	private Long id;
	
	@NotEmpty(message = "Card Number is required.")
	private String cardNumber;

	@NotEmpty(message = "Expiry Month is required.")
	private byte expiryMonth;

	@NotEmpty(message = "Expiry Year is required.")
	private short expiryYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
