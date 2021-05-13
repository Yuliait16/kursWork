package by.modelSilvanovichYV.flower;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Flower")
public class FlowerSilvanovichYV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="count")
    private Integer count;

    @Column(name="price")
    private Double price;

    @Column(name="picture")
    private String picture;

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getCount() {
        return count;
    }

    public Double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }
}
