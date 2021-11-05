package com.py.sfc.app.config;

import java.util.List;


import com.py.sfc.app.base.PaginadoParam;
import com.py.sfc.app.base.PaginadoResult;



public interface IDAOGenerico<T, I> {

	public T insertarSinClavePrimaria(T record) throws Exception;

	public void eliminar(I id) throws Exception;

	void modificar(T record) throws Exception;

	public T obtener(I id) throws Exception;

	public List<T> listar() throws Exception;

	public PaginadoResult<T> listarPaginado(PaginadoParam<T> param) throws Exception;

	public void activar(I id);

	public void descactivar(I id);

}
