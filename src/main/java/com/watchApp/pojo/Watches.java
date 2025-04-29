package com.watchApp.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Watches {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "stock")
	private Integer stock;
}
