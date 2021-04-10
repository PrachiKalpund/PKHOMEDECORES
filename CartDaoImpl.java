package com.pkhomedecores.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pkhomedecores.utility.DBUtility;
import com.pkhomedecores.pojo.Cart;
import com.pkhomedecores.pojo.Furniture;

public class CartDaoImpl implements CartDao{

	Connection con=DBUtility.connection();
	PreparedStatement ps;
	ResultSet rs;
	String str;
	Furniture f;
	int row;
	
	@Override
	public boolean addCart(Cart cart)
	{
		str="Insert Into cart(furnitureId, quantity, custEmail) Values(?,?,?)";
		try 
		{
			ps=con.prepareStatement(str);
			ps.setInt(1, cart.getFurnitureId());
			ps.setInt(2, cart.getQuantity());
			ps.setString(3, cart.getEmail());

			row=ps.executeUpdate();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Cart> showMyCart(String custEmail) {
		
		
		
		System.out.println(custEmail);//should i run?
		str="Select ct.cartId,f.furnitureName,f.furniturePrice,ct.quantity from furniture as f inner join cart as ct where f.furnitureId=ct.furnitureId and custEmail=?";        
		List<Cart> cl=new ArrayList<Cart>();
		try {
			ps=con.prepareStatement(str);
			ps.setString(1,custEmail);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Cart c=new Cart();
				c.setCartId(rs.getInt("CartId"));
				c.setFurnitureName(rs.getString("FurnitureName"));
				c.setFurniturePrice(rs.getDouble("FurniturePrice"));
				c.setQuantity(rs.getInt("Quantity"));
				cl.add(c);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public boolean deleteCartById(int cartid) {
		str="Delete from Cart where cartId=?";
		try
		{
			ps=con.prepareStatement(str);
			ps.setInt(1,cartid);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean clearCart(String custEmail) {
		str="Delete from Cart where custEmail=?";
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1,custEmail);
			row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();

		}
		return false;
	}
}
