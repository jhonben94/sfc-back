package com.py.sfc.app.services;

import java.util.Calendar;
import java.util.Date;
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
import com.py.sfc.app.entities.ConceptoPuntos;
import com.py.sfc.app.entities.UsoPuntos;
import com.py.sfc.app.entities.UsoPuntosDetalle;
import com.py.sfc.app.params.CargarPuntosParam;
import com.py.sfc.app.params.UsarPuntosParam;
import com.py.sfc.app.repository.BolsaPuntosRepository;

@Service
public class BolsaPuntosService implements IDAOGenerico<BolsaPuntos, Integer>{
	@Autowired
	private BolsaPuntosRepository repository;
	
	@Autowired
	private UsoPuntosService upService;
	@Autowired
	private UsoPuntosDetalleService updService;
	@Autowired
	private ConceptoPuntosService cpService;
	

	@Override
	public BolsaPuntos insertarSinClavePrimaria(BolsaPuntos record) throws Exception {
		repository.save(record);
		return record;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repository.deleteById(id);
	}

	@Override
	public void modificar(BolsaPuntos record) throws Exception {
		repository.save(record);
	}

	@Override
	public BolsaPuntos obtener(Integer id) throws Exception {
		// TODO Auto-generated method stub
		BolsaPuntos data = repository.findById(id).orElse(null);
		return data;
	}

	@Override
	public List<BolsaPuntos> listar() throws Exception {
		
		return (List<BolsaPuntos>) repository.findAll();
	}

	@Override
	public PaginadoResult<BolsaPuntos> listarPaginado(PaginadoParam<BolsaPuntos> param) throws Exception {
		// TODO Auto-generated method stub
		
		
		ExampleMatcher matcher = ExampleMatcher.matching()
			    .withStringMatcher(StringMatcher.CONTAINING);
			
			Example<BolsaPuntos> example = Example.of(param.getFiltros(),matcher);
				Page<BolsaPuntos> lista = repository.findAll(example,
					PageRequest.of(
							param.getPagina(), 
							param.getCantidad(), 
							Sort.by(
									param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
									param.getOrderBy())
							));
					PaginadoResult<BolsaPuntos> result = new PaginadoResult<>(lista);
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
	public void cargarBolsa(CargarPuntosParam param) {
		
		BolsaPuntos b = new BolsaPuntos();
		b.setCliente(param.getCliente());
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		cal.add(Calendar.DATE, 15);
		b.setFechaAsignacionPuntos(fecha);
		b.setFechaVencimientoPuntos( cal.getTime());
		b.setMontoOperacion(param.getMontoOperacion());
		b.setPuntajeUtilizado(0);
		b.setSaldoPuntos(param.getMontoOperacion());
		repository.save(b);
	}
	
	
	public void usarPuntos(UsarPuntosParam param) throws Exception {
		PaginadoParam<BolsaPuntos> data = new PaginadoParam<>();
		data.setCantidad(Integer.MAX_VALUE);
		data.setPagina(0);
		data.setOrderDir("ASC");
		data.setOrderBy("fechaAsignacionPuntos");
		BolsaPuntos filtros = new BolsaPuntos();
		filtros.setCliente(param.getCliente());
		data.setFiltros(filtros);
		// se obtiene lista de bolsas de la ultima a la mas nueva.
		List<BolsaPuntos> lista = listarConFiltros(data);
		ConceptoPuntos concepto = cpService.obtener(param.getConcepto().getConceptoPunto());
		
		Integer puntajeUtilizado = concepto.getPuntosRequeridos();
		Integer puntajeAux =0;
		UsoPuntos usoCab = new UsoPuntos();
		usoCab.setCliente(param.getCliente());
		usoCab.setConceptoPunto(param.getConcepto());
		usoCab.setPuntajeUtilizado(concepto.getPuntosRequeridos());
		upService.insertarSinClavePrimaria(usoCab);
		for (BolsaPuntos bolsaPuntos : lista) {
			
			if(puntajeUtilizado ==0) {
				break;
			}
			if(bolsaPuntos.getPuntajeUtilizado() == 0) {
				continue;
			}
			System.out.println(bolsaPuntos.getFechaAsignacionPuntos());
			// detalle  uso
			UsoPuntosDetalle upd = new UsoPuntosDetalle();
			upd.setUsoPunto(usoCab);
			upd.setBolsaPunto(bolsaPuntos);
			puntajeAux= bolsaPuntos.getSaldoPuntos()- puntajeUtilizado;
			if(puntajeAux > 0) {
				bolsaPuntos.setPuntajeUtilizado(puntajeUtilizado);
				bolsaPuntos.setSaldoPuntos(puntajeUtilizado);
				upd.setPuntajeUtilizado(puntajeUtilizado);
				updService.insertarSinClavePrimaria(upd);
				break;
			}{
				Integer utilizado = puntajeUtilizado- bolsaPuntos.getSaldoPuntos();
				bolsaPuntos.setPuntajeUtilizado(utilizado);
				bolsaPuntos.setSaldoPuntos(bolsaPuntos.getSaldoPuntos() - utilizado);
				upd.setPuntajeUtilizado(utilizado);
				puntajeUtilizado-=utilizado;
				updService.insertarSinClavePrimaria(upd);

			}
			modificar(bolsaPuntos);	
		}

	}
	
	public List<BolsaPuntos> listarConFiltros(PaginadoParam<BolsaPuntos> param) throws Exception {
	
		ExampleMatcher matcher = ExampleMatcher.matching()
			    .withStringMatcher(StringMatcher.CONTAINING);
			
			Example<BolsaPuntos> example = Example.of(param.getFiltros(),matcher);
				Page<BolsaPuntos> lista = repository.findAll(example,
					PageRequest.of(
							param.getPagina(), 
							param.getCantidad(), 
							Sort.by(
									param.getOrderDir().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
									param.getOrderBy())
							));
					return (List<BolsaPuntos> ) lista.getContent();
		
	}


}
