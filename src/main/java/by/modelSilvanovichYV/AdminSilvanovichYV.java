package by.modelSilvanovichYV;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Admin1")
public class AdminSilvanovichYV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="access")
    private String access;
}