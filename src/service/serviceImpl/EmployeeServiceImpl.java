package service.serviceImpl;

import dao.EmployeeDao;
import dao.daoImpl.EmployeeDaoImpl;
import entity.Employee;
import service.EmployeeService;
import utils.PageBean;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public void getAll(PageBean<Employee> pb) {
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		if(pb.getCurrentPage()<=0){
			pb.setCurrentPage(1);
		}else if(pb.getCurrentPage()>pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());
		}
		employeeDao.getAll(pb);
	}

	public int getTotalCount() {
		return employeeDao.getTotalCount();
	}

}
