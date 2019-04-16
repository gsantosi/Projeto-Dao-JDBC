package Testes;

import java.sql.Date;
import java.text.SimpleDateFormat;

import Classes.Departamento;
import Classes.Vendedor;

public class TesteVend {
   public static void main(String [] args) {
	   
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	   
	   Departamento dep = new Departamento(7,"Perecíveis");
	   
	   Vendedor vend = new Vendedor(2,"Raimundo","Raimundo15@gmail.com",new Date(1),9000, dep);
	   
	   System.out.println(vend);
	   
	   
   }
}
