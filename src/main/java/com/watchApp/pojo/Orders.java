package com.watchApp.pojo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_list")
@Data
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@Column(name = "customer_id")
	private Customers customer;

	@Column(name = "orderDate")
	private LocalDateTime orderDate;

	@Transient
	private List<Watches> watches;
	  
	@Column(name = "totalAmount")
	private Double totalAmount;

}
