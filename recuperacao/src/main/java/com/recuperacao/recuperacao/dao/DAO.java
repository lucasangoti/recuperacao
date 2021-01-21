package com.recuperacao.recuperacao.dao;

import java.util.List;

public interface DAO<T> {
	
	T buscaPorCod (int cod);
	
	void criar (T entity );
	
	void atualizar (T entity);
	
	void excluir (int cod);
	
	List<T> buscarTodos ();

}