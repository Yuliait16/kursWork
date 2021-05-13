package by.modelSilvanovichYV;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="User1")
public class UserSilvanovichYV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="login")
    private String login;

    @Column(name="password1")
    private String password;

    @OneToOne
    @JoinColumn(name = "id_admin")
    private AdminSilvanovichYV id_admin;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private CustomerSilvanovichYV id_customer;
}
