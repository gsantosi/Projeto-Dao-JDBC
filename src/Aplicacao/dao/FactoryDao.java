package Aplicacao.dao;

import ImplementacaoDao.ImplementacaoDepartamentoDao;
import ImplementacaoDao.ImplementacaoVendedorDao;

public class FactoryDao {

	public static VendedorDao createVendedorDao() {
       return new ImplementacaoVendedorDao();
	}
	
	public static DepartamentoDao createDepartamentoDao() {
		return new ImplementacaoDepartamentoDao();
	}
	
}
