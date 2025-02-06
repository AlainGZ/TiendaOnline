package com.tienda.ordenes.controller;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ordenes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private int usuarioId;

	@Column(nullable = false)
	private String productos;

	@Column(nullable = false)
	private double total;

}
