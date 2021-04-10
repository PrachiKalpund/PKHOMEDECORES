package com.pkhomedecores.dao;

import java.util.List;

import com.pkhomedecores.pojo.Customer;


	public interface CustomerDao {
		boolean addCustomer(Customer customer);
		boolean updateCustomer(Customer customer);
		boolean deleteCust(int id);
		Customer getCustByEmail(String emailId);
		List<Customer> getAllCustomer();
		boolean doLogin(String type,String email, String password);
	}

