package com.pkhomedecores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import com.pkhomedecores.pojo.Order;
import com.pkhomedecores.utility.DBUtility;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

	Connection con=DBUtility.connection();
	Connection c;
	PreparedStatement ps;
	String sql;
	ResultSet rs;
	int row;

	@Override
	public int placeOrder(String emailId) {
		int orderId=0;
		double totalcost=0.0;
		LocalDate dt=LocalDate.now();
		String orderdate=dt.toString();
		sql="select sum(f.furnitureprice*f.quantity) as totalbill from furniture f inner join Cart as ct on f.furnitureid=f.furnitureid and custemail=?";
		try
		{
			ps=con.prepareStatement(sql);	
			ps.setString(1, emailId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				totalcost=rs.getDouble("TotalBill");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		sql="Insert into orders(Orderdate, Custemail, Bill) Values(?,?,?)";
		try
		{
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dt.toString());
			ps.setString(2, emailId );
			ps.setDouble(3, totalcost);
			row=ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if(rs.next())
			{
				orderId=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderId;
	}



	@Override
	public List<Order> getMyOrders(String email) {
		sql="Select * from Orders where custemail=?";
		List<Order> list=new ArrayList<Order>();
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Order od=new Order();
				od.setOrderId(rs.getInt("OrderId"));
				od.setDate(rs.getString("OrderDate"));
				od.setEmailId(rs.getString("CustEmail"));
				od.setBill(rs.getDouble("Bill"));
				list.add(od);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public int placeOrder(Order o) {
		int orderId=0;
		sql="insert into orders(orderdate,custemail,bill) values(?,?,?)";
		try
		{
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,o.getDate());
			ps.setString(2,o.getEmailId());
			ps.setDouble(3, o.getBill());
			row=ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if(rs.next())
			{
				orderId=rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderId;
	}


	}


