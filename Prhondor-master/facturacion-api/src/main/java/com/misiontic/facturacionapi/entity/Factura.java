package com.misiontic.facturacionapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="facturas")
public class Factura {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;	
	
	@Column(name="apellido", nullable = false, length = 100)
	private String apellido;
	
	@Column(name="cedula", nullable = false)
	private Long cedula;

	@Column(name="direccion", nullable = false, length = 100)
	private String direccion;
	
	@Column(name="telefono", nullable = false)
	private Long telefono;
	
	@Column(name="fecha", nullable = false, length = 100)
	private String fecha;
	
	@Column(name="vendedor", nullable = false, length = 100)
	private String vendedor;
	
	@Column(name="articulo", nullable = false, length = 100)
	private String articulo;
	
	@Column(name="precio", nullable = false)
	private Double precio;
		
	@Column(name="stock", nullable = false)
	private Long stock;
	
	@Column(name="codigo", nullable = false)
	private Long codigo;
}





