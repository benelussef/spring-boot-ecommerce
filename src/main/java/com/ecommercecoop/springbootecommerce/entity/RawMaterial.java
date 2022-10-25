package com.ecommercecoop.springbootecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="raw_material")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private Double unit_price;

    @Column(name = "image_url")
    private String image_url;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "product_rm",
            joinColumns = @JoinColumn(name="raw_material_id"),
            inverseJoinColumns = @JoinColumn(name="p_Id")
    )
    private List<Product> products = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "region_raw_material",
            joinColumns = @JoinColumn(name="raw_material_id"),
            inverseJoinColumns = @JoinColumn(name="reg_id")
    )
    private List<Region> regions;
}
