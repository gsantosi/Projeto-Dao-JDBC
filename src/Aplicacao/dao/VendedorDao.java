package Aplicacao.dao;

import java.util.List;

import Classes.Vendedor;

public interface VendedorDao {

	void insert (Vendedor obj);
	void update (Vendedor obj);
	void deleteById (Integer Id);
	Vendedor findById (Integer Id);
	List<Vendedor> findAll();
}
