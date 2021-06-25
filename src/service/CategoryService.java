package service;

import java.util.List;

import models.CategoryModel;

public interface CategoryService {

	 boolean insert(String catName , int pat);
	   
	 boolean eidt(int id,String catName);
	   
	   boolean delete(int id);
	   
	   CategoryModel getById(int id);
	   
	   CategoryModel getByName(String name);
	   
	   List<CategoryModel> getAll();
}
