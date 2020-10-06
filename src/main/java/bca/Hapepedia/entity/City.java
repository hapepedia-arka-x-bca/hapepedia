package bca.Hapepedia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    /**
     * 
     */
    public City() {
    }

    /**
     * return the id
     */
    public int getId() {
        return id;
    }

    /**
     * param id the id to set
     */
    public void setId(int id) {
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
