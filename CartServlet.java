package com.pkhomedecores.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pkhomedecores.dao.CartDao;
import com.pkhomedecores.dao.CartDaoImpl;
import com.pkhomedecores.dao.OrderDao;
import com.pkhomedecores.dao.OrderDaoImpl;
import com.pkhomedecores.pojo.Cart;
import com.pkhomedecores.pojo.Order;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		String email=(String)session.getAttribute("userEmail");
		String operation=request.getParameter("operation");
		CartDao dao=new CartDaoImpl();
		Cart ct = new Cart();
		
		if(operation!=null && operation.equals("addToCart")) {
			int FurnitureId=Integer.parseInt(request.getParameter("FurnitureId"));
			ct.setemailId(email);
			ct.setFurnitureId(FurnitureId);
			ct.setQuantity(1);
			boolean flag = dao.addCart(ct);
			if(flag)
			{
			request.setAttribute("Success", "Furniture Added to Cart");
			RequestDispatcher rd=request.getRequestDispatcher("FurnitureList.jsp");
			rd.forward(request, response);
			}
	}
		    else if(operation!=null && operation.equals("Delete")) {
			int cartId=Integer.parseInt(request.getParameter("id"));
			boolean flag=dao.deleteCartById(cartId);
			request.setAttribute("Success", "Furniture Deleted from Cart");
		    if(flag) 
		    {
			List<Cart> cartList=dao.showMyCart(email);
			session.setAttribute("MyCart", cartList);
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
			}
		    }
			else
			{
			System.out.println("doGet()");		
			List<Cart> cartList=dao.showMyCart(email);
			System.out.println(cartList);
			session.setAttribute("MyCart", cartList);
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//place order
		//1. find bill amount
		HttpSession session=request.getSession();
		String[] price     =request.getParameterValues("Price");
		String[] quantity  =request.getParameterValues("Quantity");
		double total=0.0;
		if 
		(price.length > 0) {
		for(int i=0;i<price.length;i++) {
		double amount=Integer.parseInt(quantity[i])*Double.parseDouble(price[i]);
		total = total+amount;
			}
		}
		//in both i gue
		//order table structure:
		//set the order obj 
		String email=(String)session.getAttribute("userEmail");
		String today=(new Date()).toString();
		Order o=new Order();
		o.setBill(total);
		o.setDate(today);
		o.setEmailId(email);
		
		//insert this obj into db
		OrderDao dao=new OrderDaoImpl();
		int orderId=dao.placeOrder(o);
		if(orderId>0) 
		{
			CartDao ctDao=new CartDaoImpl();
			ctDao.clearCart(email);
			request.setAttribute("Success", "Order Placed Successfully, Order Id: "+orderId);
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Failure", "Unable To Place Your Order");
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
		}
		
	}

}

