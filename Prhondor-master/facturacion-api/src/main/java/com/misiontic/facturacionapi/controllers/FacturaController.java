package com.misiontic.facturacionapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.misiontic.facturacionapi.dtos.FacturaDTO;
import com.misiontic.facturacionapi.entity.Factura;
import com.misiontic.facturacionapi.repository.FacturaRepository;
import com.misiontic.facturacionapi.services.FacturaService;

@RestController
public class FacturaController {

	@Autowired
	private FacturaService facturaService;

	@GetMapping(value = "/facturas/{facturaId}")
	public ResponseEntity<FacturaDTO> findById(@PathVariable("facturaId") Long facturaId) {
		Factura factura = facturaService.findById(facturaId);
		
		FacturaDTO facturaDto = FacturaDTO.builder()
				.id(factura.getId())
				.nombre(factura.getNombre())
				.apellido(factura.getApellido())
				.telefono(factura.getTelefono())
				.cedula(factura.getCedula())
				.direccion(factura.getDireccion())
				.fecha(factura.getFecha())
				.vendedor(factura.getVendedor())
				.articulo(factura.getArticulo())
				.precio(factura.getPrecio())
				.stock(factura.getStock())
				.codigo(factura.getCodigo())
				.build();
		
		return new ResponseEntity<FacturaDTO>(facturaDto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/facturas/{facturaId}")
	public ResponseEntity<Void> delete(@PathVariable("facturaId") Long facturaId) {
		facturaService.delete(facturaId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(value = "/facturas")
	public ResponseEntity<List<FacturaDTO>> findAll() {
		List<Factura> facturas = facturaService.findAll();
		
		List<FacturaDTO> facturaDto = facturas.stream().map(factura -> {
			return FacturaDTO.builder()
					.id(factura.getId())
					.nombre(factura.getNombre())
					.apellido(factura.getApellido())
					.telefono(factura.getTelefono())
					.cedula(factura.getCedula())
					.direccion(factura.getDireccion())
					.fecha(factura.getFecha())
					.vendedor(factura.getVendedor())
					.articulo(factura.getArticulo())
					.precio(factura.getPrecio())
					.stock(factura.getStock())
					.codigo(factura.getCodigo())
					.build();
		})
		.collect(Collectors.toList());
		
		return new ResponseEntity<List<FacturaDTO>>(facturaDto, HttpStatus.OK);
	}

	@PostMapping(value = "/facturas")
	public ResponseEntity<FacturaDTO> create(@RequestBody Factura factura) {
		Factura nuevoFactura = facturaService.save(factura);
		
		FacturaDTO facturaDto = FacturaDTO.builder()
				.id(nuevoFactura.getId())
				.nombre(nuevoFactura.getNombre())
				.apellido(nuevoFactura.getApellido())
				.telefono(nuevoFactura.getTelefono())
				.cedula(nuevoFactura.getCedula())
				.direccion(nuevoFactura.getDireccion())
				.fecha(nuevoFactura.getFecha())
				.vendedor(nuevoFactura.getVendedor())
				.articulo(nuevoFactura.getArticulo())
				.precio(nuevoFactura.getPrecio())
				.stock(nuevoFactura.getStock())
				.codigo(nuevoFactura.getCodigo())
				.build();
		
		return new ResponseEntity<FacturaDTO>(facturaDto, HttpStatus.CREATED);
	}

	@PutMapping(value = "/facturas")
	public ResponseEntity<FacturaDTO> update(@RequestBody Factura factura) {
		Factura existeFactura = facturaService.save(factura);
		
		FacturaDTO facturaDto = FacturaDTO.builder()
				.id(existeFactura.getId())
				.nombre(existeFactura.getNombre())
				.apellido(existeFactura.getApellido())
				.telefono(existeFactura.getTelefono())
				.cedula(existeFactura.getCedula())
				.direccion(existeFactura.getDireccion())
				.fecha(existeFactura.getFecha())
				.vendedor(existeFactura.getVendedor())
				.articulo(existeFactura.getArticulo())
				.precio(existeFactura.getPrecio())
				.stock(existeFactura.getStock())
				.codigo(existeFactura.getCodigo())
				.build();
		
		return new ResponseEntity<FacturaDTO>(facturaDto, HttpStatus.OK);
	}

}
	
	
	
	
	
	
	
	
	
	

