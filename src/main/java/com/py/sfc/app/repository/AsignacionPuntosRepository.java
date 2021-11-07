package com.py.sfc.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.py.sfc.app.entities.AsignacionPuntos;
@Repository
public interface AsignacionPuntosRepository extends JpaRepository<AsignacionPuntos, Integer>{
		@Query(value = "SELECT u "
				+ "FROM AsignacionPuntos u "
				+ "where ?1 >= u.limiteInferior  and ?1 <= u.limiteSuperior  ")
		AsignacionPuntos equivalenciaMonto(Integer monto);
}
