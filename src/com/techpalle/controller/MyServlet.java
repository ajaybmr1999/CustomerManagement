package com.techpalle.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.techpalle.dao.DataAccesss;
import com.techpalle.model.Customer;
import com.techpalle.util.SccessPage;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();
		
		switch(path)
		{
		case "/logCustomer":
			ValidateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/reg":
			getRegistrationPage(request, response);
			break;
		case "/log":
			getLoginPage(request, response);
			break; 
			default:
				getStartUpPage(request,response);
				break;
		}
	}

	private void ValidateCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		// Read the data from login.jsp file
		String e = request.getParameter("tbEmaillog");
		String p = request.getParameter("tbPasslog");
		
		//call the DAO
		boolean res = DataAccesss.validateCustomer(e, p);
		
		// Condition and Redirect to user Success page with email and password		
		if(res)
		{
			try {
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				SccessPage sp = new SccessPage();
				request.setAttribute("sucessDetails", sp);
				rd.forward(request, response);
			} 
			catch (ServletException e1) {
				e1.printStackTrace();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}else {
			getLoginPage(request, response);
		}
		
	}

	private static  void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
	
		//Read the data from jsp file
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		long m = Long.parseLong(request.getParameter("tbMobile"));
		String p = request.getParameter("tbPass");
		String s = request.getParameter("ddlStates");
		
		//Store the data in customer object
		Customer c = new Customer(n,e,m,p,s);
		
		
		//Call insertCustomer method present in dao by passing aboue object
		DataAccesss.insertCustomer(c);
		
		// Redirect to user login page with email and password
		RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
		try {
			rd.forward(request, response);
		} 
		catch (ServletException e1) {
			e1.printStackTrace();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {	
			e.printStackTrace();
		} 
		catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {	
			e.printStackTrace();
		} 
		catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) {	
			e.printStackTrace();
		} 
		catch (IOException e) {			
			e.printStackTrace();
		}
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
