package com.misiontic.facturacionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.misiontic.facturacionapi.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
