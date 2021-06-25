package Dao.Admin;

import java.util.List;

import models.CategoryModel;

public interface CategoryDao {
	
   boolean insert(String catName , int pat);
   
   boolean eidt(int id,String catName);
   
   boolean delete(int id);
   
   CategoryModel getById(int id);
   
   CategoryModel getByName(String name);
   
   List<CategoryModel> getAll();
   List<CategoryModel> getCatPat0();
   List<CategoryModel> getCatPatMore0();
   
}
