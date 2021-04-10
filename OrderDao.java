package com.pkhomedecores.dao;

import java.util.List;
import com.pkhomedecores.pojo.Order;

public interface OrderDao {
	//int placeOrder(String emailId);
	int placeOrder(String emailId);
	List<Order>getMyOrders(String email);
	int placeOrder(Order o);	
}
