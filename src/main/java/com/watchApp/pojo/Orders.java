package com.watchApp.pojo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JoinColumn(name = "customer_id")
	private Customers customer;
	
	@ManyToOne
	@JoinColumn(name = "watch_id")
	private Watches watch;

	@JsonProperty("order_date")
	@Column(name = "order_date")
	private LocalDateTime orderDate;

	@Transient
	private List<Watches> watches;
	  
	@JsonProperty("total_amount")
	@Column(name = "total_amount")
	private Double totalAmount;

}
