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
import com.py.sfc.app.entities.VencimientoPuntos;
import com.py.sfc.app.repository.VencimientoPuntosRepository;

@Service
public class VencimientoPuntosService implements IDAOGenerico<VencimientoPuntos, Integer>{
	@Autowired
	private VencimientoPuntosRepository repository;

	@Override
	public VencimientoPuntos insertarSinClavePrimaria(VencimientoPuntos record) throws Exception {
		repository.save(record);
		return record;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repository.deleteById(id);
	}

	@Override
	public void modificar(VencimientoPuntos record) throws Exception {
		repository.save(record);
	}

	@Override
	public VencimientoPuntos obtener(Integer id) throws Exception {
		// TODO Auto-generated method stub
		VencimientoPuntos data = repository.findById(id).orElse(null);
		return data;
	}

	@Override
	public List<VencimientoPuntos> listar() throws Exception {
		
		return (List<VencimientoPuntos>) repository.findAll();
	}

	@Override
	public PaginadoResult<VencimientoPuntos> listarPaginado(PaginadoParam<VencimientoPuntos> param) throws Exception {
		// TODO Auto-generated method stub
		
		
		ExampleMatcher matcher = ExampleMatcher.matching()
			    .withStringMatcher(StringMatcher.CONTAINING);
			
			Example<VencimientoPuntos> example = Example.of(param.getFiltros(),matcher);
				Page<VencimientoPuntos> lista = repository.findAll(example,
					PageRequest.of(
							param.getPagina(), 
							param.getCantidad(), 
							Sort.by(
									param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
									param.getOrderBy())
							));
					PaginadoResult<VencimientoPuntos> result = new PaginadoResult<>(lista);
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
