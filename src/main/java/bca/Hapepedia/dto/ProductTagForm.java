package bca.Hapepedia.dto;

import javax.validation.constraints.NotEmpty;

import bca.Hapepedia.entity.Product;
import bca.Hapepedia.entity.Tag;


public class ProductTagForm {

    private Long id;
	
	@NotEmpty()
    private Tag tag;
    
	@NotEmpty()
	private Product product;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
	
    
    
}
