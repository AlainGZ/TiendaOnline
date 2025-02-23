package com.tienda.pagos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@GeneratedValue
	private Long id;

	private Long ordenId;

	private double monto;

	private String metodo;

	private String estado;

	private LocalDateTime fechaPago;

	private Long referencia;
}
