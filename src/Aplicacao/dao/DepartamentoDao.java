package Aplicacao.dao;

import java.util.List;

import Aplicacao.Departamento;

public interface DepartamentoDao {

	void insert (Departamento dep);
	void update (Departamento dep);
	void deleteById (Integer id);
	Departamento FindById (Integer id);
	List<Departamento> findAll();
	
}
