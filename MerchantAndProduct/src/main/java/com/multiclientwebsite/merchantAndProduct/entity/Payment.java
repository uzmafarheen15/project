package com.multiclientwebsite.merchantAndProduct.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private Long cardNo;
    private String cardHolderName;
    private String expiration;
    private Integer cvv;
    @OneToOne
    private Customer customer;
}
