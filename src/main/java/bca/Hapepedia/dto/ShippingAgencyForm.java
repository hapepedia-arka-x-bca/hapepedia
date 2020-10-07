package bca.Hapepedia.dto;
import javax.validation.constraints.NotEmpty;

public class ShippingAgencyForm {
    private int id;

    @NotEmpty(message = "Shipping Agency needs to be named")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
