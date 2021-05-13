package by.modelSilvanovichYV;

import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Basket")
public class BasketSilvanovichYV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name = "id_flower", nullable = false)
    private FlowerSilvanovichYV id_flower;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private CustomerSilvanovichYV id_customer;

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    private String name;

    public void setId_flower(FlowerSilvanovichYV id_flower) {
        this.id_flower = id_flower;
    }

    public void setId_customer(CustomerSilvanovichYV id_customer) {
        this.id_customer = id_customer;
    }

    public int getId() {
        return id;
    }

    public FlowerSilvanovichYV getId_flower() {
        return id_flower;
    }

    public CustomerSilvanovichYV getId_customer() {
        return id_customer;
    }

    public void setName(String name) {
        this.name = name;
    }
}
