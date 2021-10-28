package com.misiontic.facturacionapi.validators;

import com.misiontic.facturacionapi.entity.Factura;

public class FacturaValidator {
	
	public static void save(Factura factura) {
		
		if(factura.getNombre() == null || factura.getNombre().trim().isEmpty()) {
			throw new RuntimeException("El nombre es obligatorio.");
		}
		
		if (factura.getNombre().length() > 100) {
			throw new RuntimeException("El nombre no puede ser mayor a 100 caracteres.");
		}
		
		if(factura.getApellido() == null || factura.getApellido().trim().isEmpty()) {
			throw new RuntimeException("El apellido es obligatorio.");
		}
		
		if (factura.getApellido().length() > 100) {
			throw new RuntimeException("El apellido no puede ser mayor a 100 caracteres.");
		}
		
		if(factura.getVendedor() == null || factura.getVendedor().trim().isEmpty()) {
			throw new RuntimeException("El nombre del vendedor es obligatorio.");
		}
		
		if (factura.getVendedor().length() > 100) {
			throw new RuntimeException("El nombre del vendedor no puede ser mayor a 100 caracteres.");
		}
		
		if(factura.getDireccion() == null || factura.getDireccion().trim().isEmpty()) {
			throw new RuntimeException("La dirección es obligatoria.");
		}
		
		if (factura.getDireccion().length() > 100) {
			throw new RuntimeException("La dirección no puede ser mayor a 100 caracteres.");
		}
		
		if(factura.getFecha() == null || factura.getFecha().trim().isEmpty()) {
			throw new RuntimeException("La fecha es obligatoria.");
		}
		
		if (factura.getFecha().length() > 100) {
			throw new RuntimeException("La fecha no puede ser mayor a 100 caracteres.");
		}
		}
		
		
	}
	
