package com.tienda.inventario.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inventario {
	@Id
	private String id; //MongoDB usa String para el id
	private Long productoId;
	private int cantidad;
}
