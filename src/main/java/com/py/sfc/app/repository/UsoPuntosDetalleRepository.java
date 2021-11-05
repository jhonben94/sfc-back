package com.py.sfc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.py.sfc.app.entities.UsoPuntos;
@Repository
public interface UsoPuntosDetalleRepository extends JpaRepository<UsoPuntos, Integer>{

}
