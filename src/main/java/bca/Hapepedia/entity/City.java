package bca.Hapepedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_city")
public class City {
    @Id
    private String id;//string mengikuti dokumentasi raja ongkir

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    public City() {
    }

    /**
     * return the id
     */
    public String getId() {
        return id;
    }

    /**
     * param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * return the name
     */
    public String getName() {
        return name;
    }

    /**
     * param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
