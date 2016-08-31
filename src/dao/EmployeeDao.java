package dao;

import entity.Employee;
import util.PageBean;

public interface EmployeeDao {

	public void getAll(PageBean<Employee> pb);
	
	public int getTotalCount();
	
	
}
