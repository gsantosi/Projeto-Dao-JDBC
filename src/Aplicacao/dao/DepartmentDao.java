package Aplicacao.dao;

import java.util.List;

import Classes.Department;

public interface DepartmentDao {

	void insert (Department dep);
	void update (Department dep);
	void deleteById (Integer id);
	Department FindById (Integer id);
	List<Department> findAll();
	
}
