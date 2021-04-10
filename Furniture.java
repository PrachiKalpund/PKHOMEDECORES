package com.pkhomedecores.pojo;

public class Furniture 
	{
		private int FurnitureId;
		private String FurnitureName,FurnitureCategory;
		private double FurniturePrice;
		public Furniture() {
		}
		public Furniture(String FurnitureName, String FurnitureCategory, double FurniturePrice) {
			this.FurnitureName = FurnitureName;
			this.FurnitureCategory = FurnitureCategory;
			this.FurniturePrice = FurniturePrice;
		}
		public int getFurnitureId() {
			return FurnitureId;
	    }
		public void setFurnitureId(int FurnitureId) {
			this.FurnitureId = FurnitureId;
		}
		public String getFurnitureName() {
			return FurnitureName;
		}
		public void setFurnitureName(String FurnitureName) {
			this.FurnitureName = FurnitureName;
		}
		public String getFurnitureCategory() {
			return FurnitureCategory;
		}
		public void setFurnitureCategory(String FurnitureCategory) {
			this.FurnitureCategory = FurnitureCategory;
		}
		public double getFurniturePrice() {
			return FurniturePrice;
		}
		public void setFurniturePrice(double FurniturePrice) {
			this.FurniturePrice = FurniturePrice;
		}
		@Override
		public String toString() {
			return "Furniture [FurnitureId=" + FurnitureId + ", FurnitureName=" + FurnitureName + ", FurnitureCategory="
					+ FurnitureCategory + ", FurniturePrice=" + FurniturePrice + "]";
		}	

	}
