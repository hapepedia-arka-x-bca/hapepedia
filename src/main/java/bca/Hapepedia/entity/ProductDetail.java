package bca.Hapepedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product_detail")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Product product;

	@OneToOne
	private Color color;

	@OneToOne
	private Varian varian;
	
	@Column(nullable = false)
	private Long Stock;
	
	@Column(nullable = false)
	private Double price;

	
}
