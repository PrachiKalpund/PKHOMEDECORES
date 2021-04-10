package com.pkhomedecores.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkhomedecores.pojo.Customer;
import com.pkhomedecores.dao.CustomerDao;
import com.pkhomedecores.dao.CustomerDaoImpl;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();
		Customer cust = new Customer();
		CustomerDao dao=new CustomerDaoImpl();
		HttpSession session=request.getSession();
		List<Customer> custList;
		String operation=request.getParameter("operation");
		if(operation!=null && operation.equals("delete")) 
		{
			int id=Integer.parseInt(request.getParameter("id"));
			boolean flag=dao.deleteCust(id);
			if(flag)
			{
				request.setAttribute("Success", "Customer Deleted Successfully!!!");
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
			else
			{
			request.setAttribute("Failure", "Error In Deleting");
			custList=dao.getAllCustomer();
			session.setAttribute("custlist", custList);
			RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request,response);
		}
		}
		else if(operation!=null&&operation.equals("getCust"))
        {
	       String email = (String)session.getAttribute("userEmail");
	       Customer c = dao.getCustByEmail(email);
	       session.setAttribute("Custtoupdate", c);
	       response.sendRedirect("UpdateCustomer.jsp");
        }
/*
 * else if(operation!=null&&operation.equals("update")) { int id =
 * Integer.parseInt(request.getParameter("id")); Customer = dao.getCustomerById(id);
 * session.setAttribute("custtoupdate", c);
 * response.sendRedirect("UpdateCustomer.jsp"); }
 */
            else
           {
           List<Customer> clist = dao.getAllCustomer();
           session.setAttribute("custlist", clist);
           RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
           rd.forward(request,response);
           }
		
         }
         

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd;
		PrintWriter out = response.getWriter();
		CustomerDao dao=new CustomerDaoImpl();
		HttpSession session=request.getSession();
        Customer c=new Customer();
		c.setCustName(request.getParameter("custName"));
		c.setCustEmail(request.getParameter("custEmail"));
		c.setCustPass(request.getParameter("custPassword"));
		c.setCustContact(request.getParameter("custContact"));
		c.setCustAddress(request.getParameter("custAddress"));
		
		String operation = request.getParameter("operation");	
		if(operation.equals("addCust")) {
			boolean flag=dao.addCustomer(c);
			if(flag) {
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				out.write("Success");
			}
			else 
			{
				rd=request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
				out.write("Error");
			}
				
		}
		else
		{
			int id = Integer.parseInt(request.getParameter("CustId"));
			c.setCustId(id);
			boolean flag = dao.updateCustomer(c);
			if(flag) 
				{
				session.invalidate();
				request.setAttribute("Success", "Profile Updated Successfully... Please Login Again");
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				}
			else
			{
				request.setAttribute("Failure", "Profile not updated... Please Try Again");
				rd=request.getRequestDispatcher("UpdateCustomer.jsp");
				rd.forward(request, response);
		     }
          }
	}
}

