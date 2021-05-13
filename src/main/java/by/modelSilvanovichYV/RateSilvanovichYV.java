package by.modelSilvanovichYV;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="rates")
public class RateSilvanovichYV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="rate")
    private String rate;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerSilvanovichYV id_customer;

    public String getRates() {
        return rate;
    }

    public void setRates(String rate) {
        this.rate = rate;
    }

    public CustomerSilvanovichYV getId_customer() {
        return id_customer;
    }

    public void setId_customer(CustomerSilvanovichYV id_customer) {
        this.id_customer = id_customer;
    }
}

