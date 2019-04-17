package ImplementacaoDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Aplicacao.dao.SellerDao;
import Classes.Department;
import Classes.Seller;
import db.DbException;

public class ImplementacaoSellerDao implements SellerDao {

	private Connection conn = null;

	public ImplementacaoSellerDao(Connection conn) {
		this.conn = conn;
	}

	public ImplementacaoSellerDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id)  {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		
			ps = conn.prepareStatement(
				
					"SELECT seller.*,department.Name as DepName " 
				   +"FROM seller INNER JOIN department "
				   +"ON seller.DepartmentId = Department.Id "
				   +"WHERE DepartmentId = ?");
			
		
			ps.setInt(1, id);
			rs = ps.executeQuery();
		
		if(rs.next()) {
			
			Department depart = new Department();
			depart.setId(rs.getInt("DepartmentId"));
			depart.setName(rs.getString("DepName"));	
	        Seller obj = new Seller();
	        obj.setId(rs.getInt("Id"));
	        obj.setName(rs.getString("Email"));
	        obj.setBaseSalary(rs.getDouble("BaseSalary"));
	        obj.setBirthDate(rs.getDate("BirthDate"));
	        obj.setDepartamento(depart);
	        return obj;
		}
		
		return null;
		}catch(SQLException e){
			throw new DbException(e.getMessage()); 
		}

		}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
