package com.py.sfc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.Clientes;
import com.py.sfc.app.entities.ConceptoPuntos;
@Repository
public interface ConceptoPuntosRepository extends JpaRepository<ConceptoPuntos, Integer>{

}
