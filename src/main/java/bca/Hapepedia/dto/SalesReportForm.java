package bca.Hapepedia.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

public class SalesReportForm {

    private Long id;
    
    @NotEmpty(message="Code is required")
    private Long customer;
    @NotEmpty(message="Code is required")
    private Long order;
    @NotEmpty(message="Code is required")
	private Long admin;
	@NotEmpty(message="Code is required")
	private Timestamp arrivalDate;
	@NotEmpty(message="Code is required")
	private String shippingNumber;
	@NotEmpty(message="Code is required")
	private Double totalPayment;

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

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getAdmin() {
        return admin;
    }

    public void setAdmin(Long admin) {
        this.admin = admin;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getShippingNumber() {
        return shippingNumber;
    }

    public void setShippingNumber(String shippingNumber) {
        this.shippingNumber = shippingNumber;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }
	
        
    
}
