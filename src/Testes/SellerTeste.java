package Testes;

import java.sql.Date;
import java.util.List;

import Aplicacao.dao.FactoryDao;
import Aplicacao.dao.SellerDao;
import Classes.Department;
import Classes.Seller;

public class SellerTeste {
   public static void main(String [] args) {
	
	   SellerDao sellerDao = FactoryDao.createSellerrDao();
	   
       Seller seller = sellerDao.findById(2);
       
       System.out.println("======== TESTE1 =========");
       System.out.println(seller);
       
       System.out.println("\n======== TESTE2 =========");
       Department departamento = new Department(1,null);
       List<Seller> array = sellerDao.findAllDepartment(departamento);
       
       for(Seller x: array) {
    	    System.out.println(x);
       }
       
       System.out.println("\n======== TESTE3 =========");
       Seller seller1 = new Seller(2,"Joao","joao@gmail",new Date(0), 5000, departamento );
       sellerDao.insert(seller1);
       System.out.println("O id é: " + seller1.getId());
   }
}