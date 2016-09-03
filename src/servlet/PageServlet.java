package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;
import service.serviceImpl.EmployeeServiceImpl;
import utils.PageBean;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String uri;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String currPage = request.getParameter("currentPage");
		if(currPage==null||"".equals(currPage.trim())){
			currPage = "1";
		}
	
		int currentPage = Integer.parseInt(currPage);
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrentPage(currentPage);
		
		employeeService.getAll(pageBean);
		request.setAttribute("pageBean", pageBean);
		
		uri = "/list.jsp";
		request.getRequestDispatcher(uri).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
