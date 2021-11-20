package com.py.sfc.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.py.sfc.app.entities.AsignacionPuntos;
import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.Clientes;
@Repository
public interface BolsaPuntosRepository extends JpaRepository<BolsaPuntos, Integer>{
	List<BolsaPuntos> findByFechaVencimientoPuntos(Date fechaVencimientoPuntos);
	
	@Query(value = " SELECT u "
			+ "FROM BolsaPuntos u "
			+ "where ?1 = u.fechaVencimientoPuntos  and u.saldoPuntos <> 0")
	List<BolsaPuntos> bolsasVencidas(Date fechaVencimiento);
	
	@Query(value = " SELECT DISTINCT u "
			+ "FROM BolsaPuntos u "
			+ "where u.fechaVencimientoPuntos  BETWEEN ?1 AND ?2 and u.saldoPuntos >0")
	List<BolsaPuntos> bolsasPorVencer(Date fechaIni, Date fechaFin);
	
	@Query(value = " SELECT u "
			+ "FROM BolsaPuntos u "
			+ "where u.cliente.cliente =?1 AND u.saldoPuntos BETWEEN ?2 AND ?3")
	List<BolsaPuntos> bolsasConsulta(Integer cliente, Integer ini, Integer fin);
	
	@Query(value = " SELECT SUM(u.saldoPuntos) "
			+ "FROM BolsaPuntos u "
			+ "where u.cliente.cliente =?1 ")
	Integer bolsasConsultaSaldo(Integer cliente);
	
}
