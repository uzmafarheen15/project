package com.multiclientwebsite.merchantAndProduct.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long merchantId;
    private String merchantName;

    @JsonManagedReference
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> product;

    public Merchant(String merchantName) {
        this.merchantName = merchantName;
    }

}















