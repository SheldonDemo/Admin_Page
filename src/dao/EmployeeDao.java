package dao;

import entity.Employee;
import utils.PageBean;

public interface EmployeeDao {

	public void getAll(PageBean<Employee> pb);
	
	public int getTotalCount();
	
	
}
