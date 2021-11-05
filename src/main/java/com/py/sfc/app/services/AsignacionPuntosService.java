package com.py.sfc.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.py.sfc.app.base.PaginadoParam;
import com.py.sfc.app.base.PaginadoResult;
import com.py.sfc.app.config.IDAOGenerico;
import com.py.sfc.app.entities.AsignacionPuntos;
import com.py.sfc.app.repository.AsignacionPuntosRepository;

@Service
public class AsignacionPuntosService implements IDAOGenerico<AsignacionPuntos, Integer>{
	@Autowired
	private AsignacionPuntosRepository repository;

	@Override
	public AsignacionPuntos insertarSinClavePrimaria(AsignacionPuntos record) throws Exception {
		repository.save(record);
		return record;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repository.deleteById(id);
	}

	@Override
	public void modificar(AsignacionPuntos record) throws Exception {
		repository.save(record);
	}

	@Override
	public AsignacionPuntos obtener(Integer id) throws Exception {
		// TODO Auto-generated method stub
		AsignacionPuntos data = repository.findById(id).orElse(null);
		return data;
	}

	@Override
	public List<AsignacionPuntos> listar() throws Exception {
		
		return (List<AsignacionPuntos>) repository.findAll();
	}

	@Override
	public PaginadoResult<AsignacionPuntos> listarPaginado(PaginadoParam<AsignacionPuntos> param) throws Exception {
		// TODO Auto-generated method stub
		
		
		ExampleMatcher matcher = ExampleMatcher.matching()
			    .withStringMatcher(StringMatcher.CONTAINING);
			
			Example<AsignacionPuntos> example = Example.of(param.getFiltros(),matcher);
				Page<AsignacionPuntos> lista = repository.findAll(example,
					PageRequest.of(
							param.getPagina(), 
							param.getCantidad(), 
							Sort.by(
									param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
									param.getOrderBy())
							));
					PaginadoResult<AsignacionPuntos> result = new PaginadoResult<>(lista);
					return result;
		
	}

	@Override
	public void activar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void descactivar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
