package com.tienda.carrito.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "item_carrito")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ItemCarrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long producto;
	private int cantidad;
}
