package com.multiclientwebsite.merchantAndProduct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private Double productPrice;
    private Integer productRating;

    private String productDescription;

    private String productType;








    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="merchantId")
    private Merchant merchant;


    public Product(String productName, Double productPrice, Integer productRating, Long merchantId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
        this.merchant = merchant;
    }

    public Product(String productName, Double productPrice, Integer productRating) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRating = productRating;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductRating() {
        return productRating;
    }

    public void setProductRating(Integer productRating) {
        this.productRating = productRating;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}


