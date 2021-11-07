package com.py.sfc.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.py.sfc.app.entities.AsignacionPuntos;
import com.py.sfc.app.entities.BolsaPuntos;
@Repository
public interface BolsaPuntosRepository extends JpaRepository<BolsaPuntos, Integer>{
	List<BolsaPuntos> findByFechaVencimientoPuntos(Date fechaVencimientoPuntos);
	
	@Query(value = "SELECT u "
			+ "FROM BolsaPuntos u "
			+ "where ?1 = u.fechaVencimientoPuntos  and u.saldoPuntos <> 0")
	List<BolsaPuntos> bolsasVencidas(Date fechaVencimiento);
}
