package com.ecommercecoop.springbootecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "region")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "regionName")
    private String regionName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private Set<Cooperative> cooperatives;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "region_raw_material",
            joinColumns = @JoinColumn(name="reg_id"),
            inverseJoinColumns = @JoinColumn(name="raw_mat_id")
    )
    private Set<RawMaterial> rawMaterials;

    public void addCooperative(Cooperative coop) {
        if(coop != null) {
            if(cooperatives == null) {
                cooperatives = new HashSet<>();
            }
            cooperatives.add(coop);
            coop.setRegion(this);
        }
    }

    public void addRawMaterial(RawMaterial rm) {
        if(rm != null) {
            if(rawMaterials == null) {
                rawMaterials = new HashSet<>();
            }
            rawMaterials.add(rm);
        }
    }
}
