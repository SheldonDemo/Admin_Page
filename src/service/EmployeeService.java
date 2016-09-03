package service;

import entity.Employee;
import utils.PageBean;

public interface EmployeeService {

	public void getAll(PageBean<Employee> pb);
	public int getTotalCount();
}
