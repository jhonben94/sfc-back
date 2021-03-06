package com.py.sfc.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.Clientes;
import com.py.sfc.app.entities.ConceptoPuntos;
import com.py.sfc.app.entities.UsoPuntos;
@Repository
public interface UsoPuntosRepository extends JpaRepository<UsoPuntos, Integer>{
	
	
	@Query(value = " SELECT count(*) "
			+ "FROM UsoPuntos u "
			+ "where cliente = ?1 and conceptoPunto = ?2")
	Integer contar( Integer cliente, Integer concepto);
}
