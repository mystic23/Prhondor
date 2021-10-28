package com.misiontic.facturacionapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misiontic.facturacionapi.entity.Factura;
import com.misiontic.facturacionapi.repository.FacturaRepository;
import com.misiontic.facturacionapi.validators.FacturaValidator;

@Service
public class FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepo;

	public Factura findById(Long facturaId) {
		Factura factura = facturaRepo.findById(facturaId)
				.orElseThrow(() -> new RuntimeException("No existe la factura."));
		return factura;
	}
	
	@Transactional
	public void delete(Long facturaId) {
		Factura factura = facturaRepo.findById(facturaId)
				.orElseThrow(() -> new RuntimeException("No existe la factura."));
		facturaRepo.delete(factura);
	}
	
	public List<Factura> findAll() {
		List<Factura> facturas = facturaRepo.findAll();
		return facturas;
	}
	
	@Transactional
	public Factura save(Factura factura) {
		
		FacturaValidator.save(factura);
		
		if (factura.getId() == null) {
			Factura nuevaFactura = facturaRepo.save(factura);
			return nuevaFactura;
		}
		
		Factura existeFactura = facturaRepo.findById(factura.getId())
				.orElseThrow(() -> new RuntimeException("No existe la factura."));
		
		existeFactura.setNombre(factura.getNombre());
		existeFactura.setApellido(factura.getApellido());
		existeFactura.setCedula(factura.getCedula());
		existeFactura.setDireccion(factura.getDireccion());
		existeFactura.setTelefono(factura.getTelefono());
		existeFactura.setFecha(factura.getFecha());
		existeFactura.setVendedor(factura.getVendedor());
		existeFactura.setArticulo(factura.getArticulo());
		existeFactura.setPrecio(factura.getPrecio());
		existeFactura.setStock(factura.getStock());
		existeFactura.setCodigo(factura.getCodigo());
		
		facturaRepo.save(existeFactura);
		
		return existeFactura;
	}
}

