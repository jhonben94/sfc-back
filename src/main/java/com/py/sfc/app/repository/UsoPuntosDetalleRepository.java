package com.py.sfc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.py.sfc.app.entities.UsoPuntos;
import com.py.sfc.app.entities.UsoPuntosDetalle;
@Repository
public interface UsoPuntosDetalleRepository extends JpaRepository<UsoPuntosDetalle, Integer>{

}
