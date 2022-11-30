package com.multiclientwebsite.merchantAndProduct.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

//    @Min(value = 0, message = "Total amount cannot be less than 0")
    @NotNull
//            (message = "Total amount should not be null")
    private Double totalAmount=0.0;

    @JsonBackReference
    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private Customer customer;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartItem> cartItems= new ArrayList<>();

}






