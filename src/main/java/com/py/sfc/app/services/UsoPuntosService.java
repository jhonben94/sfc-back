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
import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.UsoPuntos;
import com.py.sfc.app.params.UsarPuntosParam;
import com.py.sfc.app.repository.UsoPuntosRepository;

@Service
public class UsoPuntosService implements IDAOGenerico<UsoPuntos, Integer>{
	@Autowired
	private UsoPuntosRepository repository;
	@Autowired
	private BolsaPuntosService bolsaService;

	@Override
	public UsoPuntos insertarSinClavePrimaria(UsoPuntos record) throws Exception {
		repository.save(record);
		return record;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repository.deleteById(id);
	}

	@Override
	public void modificar(UsoPuntos record) throws Exception {
		repository.save(record);
	}

	@Override
	public UsoPuntos obtener(Integer id) throws Exception {
		// TODO Auto-generated method stub
		UsoPuntos data = repository.findById(id).orElse(null);
		return data;
	}

	@Override
	public List<UsoPuntos> listar() throws Exception {
		
		return (List<UsoPuntos>) repository.findAll();
	}

	@Override
	public PaginadoResult<UsoPuntos> listarPaginado(PaginadoParam<UsoPuntos> param) throws Exception {
		// TODO Auto-generated method stub
		
		
		ExampleMatcher matcher = ExampleMatcher.matching()
			    .withStringMatcher(StringMatcher.CONTAINING);
			
			Example<UsoPuntos> example = Example.of(param.getFiltros(),matcher);
				Page<UsoPuntos> lista = repository.findAll(example,
					PageRequest.of(
							param.getPagina(), 
							param.getCantidad(), 
							Sort.by(
									param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
									param.getOrderBy())
							));
					PaginadoResult<UsoPuntos> result = new PaginadoResult<>(lista);
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
	public void usarPuntos(UsarPuntosParam param) throws Exception {
		PaginadoParam<BolsaPuntos> data = new PaginadoParam<>();
		data.setCantidad(Integer.MAX_VALUE);
		data.setPagina(1);
		data.setOrderDir("DESC");
		data.setOrderBy("fechaAsignacion");
		BolsaPuntos filtros = new BolsaPuntos();
		filtros.setCliente(param.getCliente());
		
		PaginadoResult<BolsaPuntos> lista = bolsaService.listarPaginado(data);
		
		List<BolsaPuntos> bolsas = lista.getLista();
		
	}

}
