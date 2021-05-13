package by.modelSilvanovichYV;

import by.modelSilvanovichYV.flower.FlowerSilvanovichYV;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Delivery")
public class DeliveriesSilvanovichYV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="address")
    private String address;

    @Column(name="cardnumber")
    private String cardnumber;

    @Column(name="securitycode")
    private Integer securitycode;

    @Column(name="expirationdate")
    private String expirationdate;

    @Column(name="date_of_delivery")
    private String date_of_delivery;

    @OneToOne
    @JoinColumn(name = "id_flower")
    private FlowerSilvanovichYV id_flower;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private CustomerSilvanovichYV id_customer;

    @Column(name="cost")
    private Double cost;

    public void setId_flower(FlowerSilvanovichYV id_flower) {
        this.id_flower = id_flower;
    }

    public void setId_customer(CustomerSilvanovichYV id_customer) {
        this.id_customer = id_customer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setSecuritycode(Integer securitycode) {
        this.securitycode = securitycode;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public void setDate_of_delivery(String date_of_delivery) {
        this.date_of_delivery = date_of_delivery;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
