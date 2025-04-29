package com.watchApp.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_list")
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
    @Column(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @Column(name = "watch_id")
    private Watches watch;

    @Column(name = "quantity")
    private Integer quantity;
}

