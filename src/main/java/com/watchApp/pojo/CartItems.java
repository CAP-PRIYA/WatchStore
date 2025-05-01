package com.watchApp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_items")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

   
    @ManyToOne
    @JoinColumn(name = "watch_id")
    private Watches watch;

    @Column(name = "quantity")
    private Integer quantity;
}

