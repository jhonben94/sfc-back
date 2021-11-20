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
import com.py.sfc.app.entities.Clientes;
import com.py.sfc.app.repository.ClientesRepository;

@Service
public class ClientesService implements IDAOGenerico<Clientes, Integer>{
	@Autowired
	private ClientesRepository repository;

	@Override
	public Clientes insertarSinClavePrimaria(Clientes record) throws Exception {
		repository.save(record);
		return record;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repository.deleteById(id);
	}

	@Override
	public void modificar(Clientes record) throws Exception {
		repository.save(record);
	}

	@Override
	public Clientes obtener(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Clientes data = repository.findById(id).orElse(null);
		return data;
	}

	@Override
	public List<Clientes> listar() throws Exception {
		
		return (List<Clientes>) repository.findAll();
	}

	@Override
	public PaginadoResult<Clientes> listarPaginado(PaginadoParam<Clientes> param) throws Exception {
		// TODO Auto-generated method stub
		
		
		ExampleMatcher matcher = ExampleMatcher.matching()
			    .withStringMatcher(StringMatcher.CONTAINING);
			
			Example<Clientes> example = Example.of(param.getFiltros(),matcher);
				Page<Clientes> lista = repository.findAll(example,
					PageRequest.of(
							param.getPagina(), 
							param.getCantidad(), 
							Sort.by(
									param.getOrderDir().toUpperCase().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
									param.getOrderBy())
							));
					PaginadoResult<Clientes> result = new PaginadoResult<>(lista);
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
