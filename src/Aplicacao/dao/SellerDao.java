package Aplicacao.dao;

import java.util.List;

import Classes.Seller;

public interface SellerDao {

	void insert (Seller obj);
	void update (Seller obj);
	void deleteById (Integer Id);
	Seller findById (Integer Id);
	List<Seller> findAll();
}
