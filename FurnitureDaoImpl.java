package com.pkhomedecores.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.pkhomedecores.pojo.Furniture;
	import com.pkhomedecores.utility.DBUtility;

	import java.sql.ResultSet;

	public class FurnitureDaoImpl implements FurnitureDao
	{
		Furniture furniture;
		PreparedStatement stmt;
	
      @Override
		public boolean addFurniture(Furniture furniture) {
			int row=0;
			try(Connection con=DBUtility.connection())
			{
				
				stmt=con.prepareStatement("Insert into Furniture(Furniturename, FurnitureCat, FurniturePrice) Values(?,?,?)");
				stmt.setString(1,furniture.getFurnitureName());
				stmt.setString(2,furniture.getFurnitureCategory());
				stmt.setDouble(3, furniture.getFurniturePrice());

				row=stmt.executeUpdate();
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
		public boolean updateFurniture(Furniture furniture) {
			int row=0;
			String data="Update Furniture Set furnitureName=?, furnitureCat=?,  furniturePrice=? where furnitureId=?";
			try(Connection con=DBUtility.connection())
			{
				PreparedStatement stmt=con.prepareStatement(data);
				stmt.setString(1, furniture.getFurnitureName());
				stmt.setString(2, furniture.getFurnitureCategory());
				stmt.setDouble(3, furniture.getFurniturePrice());
				stmt.setInt(4, furniture.getFurnitureId());
				row=stmt.executeUpdate();
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
		public boolean deleteFurniture(int id) {
			String delete=""
					+ "Delete from Furniture where furnitureId=?";
			int row=0;
			try(Connection con=DBUtility.connection())
			{
				stmt=con.prepareStatement(delete);
				stmt.setInt(1, id);
				row=stmt.executeUpdate();
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
		public Furniture getFurnitureById(int furnitureId) {
			
			Furniture  f = new Furniture();

			try(Connection con=DBUtility.connection())
			{
				String search="Select * from furniture where furnitureId=?";
				stmt=con.prepareStatement(search);
				stmt.setInt(1, furnitureId);
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					f.setFurnitureId(rs.getInt("furnitureId"));
					f.setFurnitureName(rs.getString("furnitureName"));
					f.setFurnitureCategory(rs.getString("furnitureCat"));
					f.setFurniturePrice(rs.getInt("furniturePrice"));
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return f;
		}

	

		@Override
		public List<Furniture> getAllFurniture()
		{
			List<Furniture> al=new ArrayList<>();
			
			
			
			try(Connection con=DBUtility.connection()) 
			{
				String display="Select * from furniture";
				PreparedStatement stmt=con.prepareStatement(display);
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					Furniture f= new Furniture();
					f.setFurnitureId(rs.getInt("furnitureId"));
					f.setFurnitureName(rs.getString("furnitureName"));
					f.setFurnitureCategory(rs.getString("furnitureCat"));
					f.setFurniturePrice(rs.getInt("furniturePrice"));
					al.add(f);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return al;
		}

		@Override
		public List<Furniture> getAllFurniture(String FurnitureCategory) {
			// TODO Auto-generated method stub
			return null;
		}

//		@Override
//		public List<Furniture> getFurnitureBycategory(String furnitureCategory) {
//			String category="Select * from Furniture where category=?";
//
//
//			ArrayList<Furniture> al=new ArrayList<>();
//			try(Connection con=DBUtility.connection())
//			{
//				stmt=con.prepareStatement(category);
//				stmt.setString(1,furnitureCategory);
//				ResultSet rs=stmt.executeQuery();
//				while(rs.next())
//				{
//					furniture=new Furniture(rs.getString("furnitureName"),rs.getString("furnitureCat"),rs.getDouble("furniturePrice"));
//					furniture.setFurnitureId(rs.getInt("furnitureId"));
//					al.add(furniture);
//				}
//			}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
//			return al;
//		}

	}
