package Aplicacao.dao;

import ImplementacaoDao.ImplementacaoSellerDao;
import db.DB;

public class FactoryDao {

	public static SellerDao createSellerrDao() {
       return new ImplementacaoSellerDao(DB.getConnection());
	}
	
	
	
}
