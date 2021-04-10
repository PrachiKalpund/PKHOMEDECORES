package com.pkhomedecores.pojo;

public class Order {
	
		int OrderId;
		String date,emailId;
		double bill;

		
		
		 public int getOrderId() {
			return OrderId;
		}
		public void setOrderId(int orderId) {
			OrderId = orderId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		
		public void setBill(double bill) {
			this.bill = bill;
		}
		
		public double getBill() {
			return bill;
		}
		@Override
		public String toString() {
			return "Order [OrderId=" + OrderId + ", date=" + date + ", emailId=" + emailId + ", bill=" + bill + "]";
		
		}	
	}





