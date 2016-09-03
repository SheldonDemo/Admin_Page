package dao.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.EmployeeDao;
import entity.Employee;
import utils.JDBCUtil;
import utils.PageBean;

public class EmployeeDaoImpl implements EmployeeDao {


	@Override
	public void getAll(PageBean<Employee> pb) {

		
		int currentPage = pb.getCurrentPage();
		int index = (currentPage-1)*pb.getPageCount();
		int count = pb.getPageCount();
		
		String sql = "select * from employee limit ?,?";
		try {
			QueryRunner qr = JDBCUtil.getQueryRunner("employee");
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class),index,count);
			pb.setPageData(pageData);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from employee";
		try {
			QueryRunner qr = JDBCUtil.getQueryRunner("employee");
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
