package com.tienda.pagos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="pagos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pagos {
}
