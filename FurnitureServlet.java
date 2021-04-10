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

import com.pkhomedecores.dao.FurnitureDao;
import com.pkhomedecores.dao.FurnitureDaoImpl;
import com.pkhomedecores.pojo.Furniture;

/**
 * Servlet implementation class FurnitureServlet
 */
@WebServlet("/FurnitureServlet")
public class FurnitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FurnitureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FurnitureDao dao=new FurnitureDaoImpl();
		String operation=request.getParameter("operation");
		PrintWriter out = response.getWriter();
		//HttpSession session= request.getSession();//need this for sharing Furniturelist with jsp
		HttpSession session=request.getSession(true);
		if(operation !=null && operation.equals("delete")){
			//delete the food
			/*
			String id=request.getParameter("id");//"1"
			int FurnitureId = Integer.parseInt(id);
			 */
			int FurnitureId = Integer.parseInt(request.getParameter("id"));
			boolean flag=dao.deleteFurniture(FurnitureId);
			if(flag) out.print("<h1>Success</h1>");
			else 	out.print("<h1>Error</h1>");
		}
		else if(operation !=null && operation.equals("getFurnitureObj")) {
			//get Furniture obj
			int FurnitureId = Integer.parseInt(request.getParameter("id"));
			Furniture f=dao.getFurnitureById(FurnitureId);
			session.setAttribute("FurnitureToUpdate", f);
			response.sendRedirect("UpdateFurniture.jsp");
		}
		else
		{
			//code for FurnitureList
			//1.fetch the data from DaoImpl			
			List<Furniture> FList = dao.getAllFurniture();

			//2.pass this list to jsp
			//session is server side memory, which is accessible to jsp n servlet 

			session.setAttribute("FurnitureList", FList);
			response.sendRedirect("FurnitureList.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
		         //A.Adding the product in db
				//1.get the values entered in the form and 
			   //using the values we will create a product object.
			PrintWriter out = response.getWriter();
		
		String FurnitureName = request.getParameter("FurnitureName");
		String FurnitureCat= request.getParameter("FurnitureCat");
		String FurnitureP = request.getParameter("FurniturePrice");
		int FurniturePrice = Integer.parseInt(FurnitureP);
		Furniture f =new Furniture();
		f.setFurnitureCategory(FurnitureCat);
		f.setFurnitureName(FurnitureName);
		f.setFurniturePrice(FurniturePrice);
		HttpSession session = request.getSession();
		//2.Using daoimp obj we will call addProduct() and return a boolean value.
		FurnitureDao dao = new FurnitureDaoImpl();
		String operation= request.getParameter("operation");
		
		if(operation.equals("addFurniture"))
		{
		boolean flag = dao.addFurniture(f);
		
			//3. based on the return value, we can generate response to client
			if (flag) 	
			{
//				out.write("Success");
				List<Furniture> FurnitureList = dao.getAllFurniture();
				session.setAttribute("FurnitureList", FurnitureList);
				request.setAttribute("Success", "Furniture Added Successfully...");
				RequestDispatcher rd=request.getRequestDispatcher("FurnitureList.jsp");
				rd.forward(request, response);
			}
			else		
			{
//				out.write("Error");
				request.setAttribute("Failure", "Furniture is not Added");
				RequestDispatcher rd=request.getRequestDispatcher("AddedFurniture.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			int id=Integer.parseInt(request.getParameter("FurnitureId"));
			f.setFurnitureId(id);
			boolean flag1 = dao.updateFurniture(f);
			if (flag1) 	
			{
				//out.write("Success");
				List<Furniture> FurnitureList = dao.getAllFurniture();
				session.setAttribute("FurnitureList", FurnitureList);
				request.setAttribute("Success", "Furniture Updated Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("FurnitureList.jsp");
				rd.forward(request, response);
			}
			else		
			{
				//out.write("Error");
				request.setAttribute("Failure", "Furniture is not Updated");
				RequestDispatcher rd=request.getRequestDispatcher("UpdateFood.jsp");
				rd.forward(request, response);
			     }
		     }
	    }
  
    }

}