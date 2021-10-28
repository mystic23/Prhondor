package com.misiontic.facturacionapi.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FacturaDTO {

	private Long id, telefono, cedula, codigo, stock;
	private String nombre, apellido, direccion, fecha, vendedor, articulo;
	private Double precio;
}
