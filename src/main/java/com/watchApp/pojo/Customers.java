package com.watchApp.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Customers {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "address")
	    private String address;
	    
	    @Column(name = "phone")
	    private String phone;

}
