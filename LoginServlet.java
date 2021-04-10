package com.pkhomedecores.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkhomedecores.dao.CustomerDao;
import com.pkhomedecores.dao.CustomerDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		//This method destroys the session object on server side
       //session.setMaxInactiveInterval();//For Login out timeout
		request.setAttribute("Success", "Logged out Sucessfully...");
		RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		//Printwriter is the class which displays something on browser
		//out.print("<h2>Response from doPost()</h2>");
		String type=request.getParameter("type");
		String email=request.getParameter("custEmail");
		String password = request.getParameter("custPass");
		CustomerDao dao=new CustomerDaoImpl();
		boolean flag = dao.doLogin(type, email, password);
		if (flag) {
			if(type.equals("user"))
				session.setAttribute("userEmail", email);
			if(type.equals("admin"))
				session.setAttribute("adminEmail", email);
//			request.setAttribute("Success", "You Have Logged in Successfully...");
//			RequestDispatcher rd=request.getRequestDispatcher("FurnitureServlet");
//			rd.forward(request, response);		
			response.sendRedirect("FurnitureServlet");
		}
		else {
			request.setAttribute("Failure", "Kindly Check Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}		
	}

}

