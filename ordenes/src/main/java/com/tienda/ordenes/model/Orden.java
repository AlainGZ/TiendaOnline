package com.tienda.ordenes.model;

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

	private Long usuarioId;

	private LocalDateTime fecha;

	private double total;

	@ElementCollection
	private List<Long> productos;

}
