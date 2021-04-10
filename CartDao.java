package com.pkhomedecores.dao;

import java.util.List;
import com.pkhomedecores.pojo.Cart;


public interface CartDao {
	boolean addCart(Cart cart);
	List<Cart> showMyCart(String email);
	boolean deleteCartById(int cartid);
	boolean clearCart(String email);
}
