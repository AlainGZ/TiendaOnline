package com.tienda.pagos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="pagos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pagos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long ordenId;

	private double monto;

	private String metodo;

	private String estado;

	private LocalDateTime fechaPago;

	private Long referencia;
}
