package ImplementacaoDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import Aplicacao.dao.SellerDao;
import Classes.Department;
import Classes.Seller;
import db.DbException;

public class ImplementacaoSellerDao implements SellerDao {

	private Connection conn = null;

	public ImplementacaoSellerDao(Connection conn) {
		this.conn = conn;
	}
	
	

	@Override
	public void insert(Seller obj) {
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
				      "INSERT INTO seller "
					  +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
				      +"VALUES "
					  +"(?, ?, ?, ?, ?)",
					   Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			ps.setDouble(4, obj.getBaseSalary());
			ps.setInt(5, obj.getDepartamento().getId());
			
			int linhas = ps.executeUpdate();
			
			if (linhas > 0 ) {
              ResultSet rs = ps.getGeneratedKeys();
              
              if (rs.next()) {
            	  int id = rs.getInt(1);
            	  obj.setId(id	);
              }

			rs.close();
			}else {
				throw new DbException("Erro inesperado!!");
				
			}	
		} catch (SQLException e) {
		
			throw new DbException(e.getMessage());
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DbException (e.getMessage());
			}
		}

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id)  {
		
		PreparedStatement ps = null;
		
		
		try {
		ps = conn.prepareStatement(
				"DELETE FROM seller "
			   +"WHERE "
			   +"Id = ?");
		
		ps.setInt(1, id);
		
	    ps.executeUpdate();
		
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
			
			Department depart = ImplementaDep(rs);	
	        Seller obj = ImplementaSeller(rs, depart);
	        return obj;
		}
		
		return null;
		}catch(SQLException e){
			throw new DbException(e.getMessage()); 
		}
		finally {
		try {
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		}

	private Seller ImplementaSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartamento(dep);
		return obj;
	}

	private Department ImplementaDep(ResultSet rs) throws SQLException {
  
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findAllDepartment(Department departamento) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		ps = conn.prepareStatement(
				"SELECT seller.*,department.Name as DepName "
				+"FROM seller INNER JOIN department "
				+"ON seller.DepartmentId = department.Id "
				+"WHERE DepartmentId = ? "
				+"ORDER BY Name" );
		
		ps.setInt(1, departamento.getId());
		rs = ps.executeQuery();
		
		List<Seller> array = new ArrayList<>();
		Map<Integer, Department> map = new HashMap<>();
		
		while (rs.next()) {
			
			Department dep = map.get(rs.getInt("DepartmentId"));
			
			if (dep == null) {
		
			    dep = ImplementaDep(rs);
				map.put(rs.getInt("DepartmentId"), dep);
			}
			
	        Seller obj = ImplementaSeller(rs, dep);
	        array.add(obj);
	
	     }
		return array;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
