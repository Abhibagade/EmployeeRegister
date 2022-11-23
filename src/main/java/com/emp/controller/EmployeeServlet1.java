package com.emp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;

/**
 * Servlet implementation class EmployeeServlet1
 */
@WebServlet("/register")
public class EmployeeServlet1 extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private EmployeeDao employeeDao;

	  public void init() {
	        employeeDao = new EmployeeDao();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");
	        String contact = request.getParameter("contact");
	        
	        Employee employee = new Employee();
	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setUsername(username);
	        employee.setPassword(password);
	        employee.setContact(contact);
	        employee.setAddress(address);
	        
	        try {
				employeeDao.registerEmployee(employee);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 response.sendRedirect("employeedetails.jsp");       
	}
}
