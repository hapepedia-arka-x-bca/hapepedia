package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class OrderStatusForm {
    private int id;

    @NotEmpty(message = "Order Status is required")
    private String orderstatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    
}
