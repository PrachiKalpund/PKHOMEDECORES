package com.pkhomedecores.pojo;

public class Cart {
	private int cartId,FurnitureId,Quantity;
	private String emailId;
	private String FurnitureName;
	private double FurniturePrice;
	
	
	public String getFurnitureName() {
		return FurnitureName;
	}
	public void setFurnitureName(String FurnitureName) {
		this.FurnitureName = FurnitureName;
	}
	public double getFurniturePrice() {
		return FurniturePrice;
	}
	public void setFurniturePrice(double FurniturePrice) {
		this.FurniturePrice = FurniturePrice;
	}
		public String getEmail() {
			return emailId;
		}
		public void setemailId(String emailId) {
			this.emailId = emailId;
		}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getFurnitureId() {
		return FurnitureId;
	}
	public void setFurnitureId(int FurnitureId) {
		this.FurnitureId = FurnitureId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [CartId=" + cartId + ", furnitureName=" + FurnitureName + ", FurniturePrice=" + FurniturePrice + ", Quantity="
				+ Quantity + "]";
		
	}
}