package com.pkhomedecores.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.pkhomedecores.pojo.Customer;
	import com.pkhomedecores.utility.DBUtility;


	public class CustomerDaoImpl implements CustomerDao {
		static Connection con;

		public boolean addCustomer(Customer customer)
		{
			boolean flag=true;
			int row=0;
			
			try {
				con=DBUtility.connection();
				String query="insert into customer(custName, custEmail, custPass, custAddress, custContact) Values(?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, customer.getCustName());
				stmt.setString(2, customer.getCustEmail());
				stmt.setString(3, customer.getCustPass());
				stmt.setString(4, customer.getCustAddress());
				stmt.setString(5,customer.getCustContact());
               row=stmt.executeUpdate();
           	if(row>0)
				return flag=true;
			else
				return flag=false;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return flag;
		}

		@Override
		public boolean updateCustomer(Customer customer) {
			int row=0;
			boolean flag=true;
			String update="Update customer set custName=?, custEmail=?, custPass=?, custContact=?, custAddress=? where custId=?";
			try
			{
				PreparedStatement stmt=con.prepareStatement(update);
				stmt.setString(1,customer.getCustName());
				stmt.setString(2, customer.getCustEmail());
				stmt.setString(3, customer.getCustPass());
				stmt.setString(4, customer.getCustContact());
				stmt.setString(5, customer.getCustAddress());
				stmt.setInt(6, customer.getCustId());
				row=stmt.executeUpdate();
				if(row>0)
					flag=true;
				else
					flag=false;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return flag;
		}

		@Override
		public boolean deleteCust(int id) {

			int row=0;
			String delete="Delete from Customer where custid=?";
			try {
				PreparedStatement stmt=con.prepareStatement(delete);
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
		public Customer getCustByEmail(String emailId) {
			String search="Select * from customer where custEmail=?";
			Customer c=new Customer();
			try{
				PreparedStatement stmt=con.prepareStatement(search);
				stmt.setString(1, emailId);
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					c.setCustId(rs.getInt("custId"));
					c.setCustName(rs.getString("custName"));
					c.setCustEmail(rs.getString("custEmail"));
					c.setCustPass(rs.getString("custPass"));
					c.setCustContact(rs.getString("custContact"));
					c.setCustAddress(rs.getString("custAddress"));
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

			return c;
		}

		@Override
		public List<Customer> getAllCustomer() {
			
			ArrayList<Customer> al=new ArrayList<Customer>();
			try
			{
				con = DBUtility.connection();
				String list="Select * from Customer";
				PreparedStatement stmt=con.prepareStatement(list);
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{ 
					Customer c = new Customer();
					c.setCustId(rs.getInt("custId"));
					c.setCustName(rs.getString("custName"));
					c.setCustEmail(rs.getString("custEmail"));
					c.setCustPass(rs.getString("custPass"));
					c.setCustContact(rs.getString("custContact"));
					c.setCustAddress(rs.getString("custAddress"));
					al.add(c);
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return al;
 }

		@Override
		public boolean doLogin(String type,String email, String password) 
		{
			PreparedStatement ps ;
			boolean flag=false;
			if(type.equals("user"))
			{
			try {
				con = DBUtility.connection();
				String query="select * from customer where custEmail=? and custPass=?";
		
				ps = con.prepareStatement(query);
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
					flag=true;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			}
			if(type.equals("admin"))
			{
				try {
					con = DBUtility.connection();
					String query="select * from admin where email = ? and password=?";
					ps = con.prepareStatement(query);
					ps.setString(1, email);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
						flag=true;
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				}
			return flag;
		}
	}
	
