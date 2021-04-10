package com.pkhomedecores.dao;

	import java.util.List;
	import com.pkhomedecores.pojo.Furniture;

	public interface FurnitureDao 
	{
		boolean addFurniture(Furniture furniture);
		boolean updateFurniture(Furniture furniture);
		boolean deleteFurniture(int id);
		Furniture getFurnitureById(int FurnitureId);
		List<Furniture> getAllFurniture(String FurnitureCategory);
		List<Furniture> getAllFurniture();
		
	}
