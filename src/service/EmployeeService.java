package service;

import entity.Employee;
import util.PageBean;

public interface EmployeeService {

	public void getAll(PageBean<Employee> pb);
	public int getTotalCount();
}
