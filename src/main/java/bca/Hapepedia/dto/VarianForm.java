package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

public class VarianForm {
    private int id;
    
    @NotEmpty(message = "Varian name is required")
    private String name;

    private long categoryId;

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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
