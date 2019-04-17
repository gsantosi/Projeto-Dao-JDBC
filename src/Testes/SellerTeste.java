package Testes;

import Aplicacao.dao.FactoryDao;
import Aplicacao.dao.SellerDao;
import Classes.Seller;




public class SellerTeste {
   public static void main(String [] args) {
	   
	   
	   
	   SellerDao sellerdao = FactoryDao.createSellerrDao();
	   
	   Seller seller = sellerdao.findById(2);
	   
	   System.out.println(seller);
	   
			   
	   
	   
	   
	   
   }
}
