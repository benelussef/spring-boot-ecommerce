package com.ecommercecoop.springbootecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cooperative")
@Getter
@Setter
public class Cooperative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "cooperative_product",
            joinColumns = @JoinColumn(name="cooperative_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private Set<Product> products;
    public void addProduct(Product p) {
        if(p != null) {
            products.add(p);
            p.getCooperatives().add(this);
        }
    }
}
