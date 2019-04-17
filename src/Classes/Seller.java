package Classes;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Seller implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Seller () {}
	
	private int Id;
	private String Name;
	private String Email;
	private Date BirthDate;
	private double BaseSalary;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Department departamento;
	
	public Seller(int Id, String Name, String Email, Date BirthDate, double BaseSalary, Department departamento) {
		
		this.Id = Id;
		this.Name = Name;
		this.Email = Email;
		this.BirthDate = BirthDate;
		this.BaseSalary = BaseSalary;
		this.departamento = departamento;
	
	}
	public Department getDepartamento() {
		return departamento;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date BirthDate) {
		this.BirthDate = BirthDate;
	}

	public double getBaseSalary() {
		return BaseSalary;
	}

	public void setBaseSalary(double BaseSalary) {
		this.BaseSalary = BaseSalary;
	}
	
	public void setDepartamento(Department departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
	public String toString() {
	
			return "id: " + Id + "\nNome: " + Name + "\nE-mail: " + Email + "\nData de Aniversário:"+ BirthDate + "\nBase do salário: "+ BaseSalary 
					+ "\nDepartameno: " + departamento.toString();
	}	
	
}
