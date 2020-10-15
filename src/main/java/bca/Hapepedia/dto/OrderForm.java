package bca.Hapepedia.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

public class OrderForm {

    private Long id;
    
    //@NotEmpty(message="Code is required")
	private Long customer;
	
	//@NotEmpty(message="Code is required")
	private Timestamp dateOrder;
	
	//@NotEmpty(message="Code is required")
	private String deliveryAddress;
	
	//@NotEmpty(message="Code is required")
	private Double totalPrice;
	
	//@NotEmpty(message="Code is required")
	private Double totalWeight;
	
	//@NotEmpty(message="Code is required")
	private Double shippingFee;
	
	//@NotEmpty(message="Code is required")
	private Long paymentMethod;
	
	//@NotEmpty(message="Code is required")
	private Double totalPayment;
	
	//@NotEmpty(message="Code is required")
    private int orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Long getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Long paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
}
