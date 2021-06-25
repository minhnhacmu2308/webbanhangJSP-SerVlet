package Dao.Admin;

import java.util.List;

import models.ProductModel;

public interface ProductDao {
	
	boolean insert(ProductModel product);
	
	boolean edit(int id,String nameP,float price,String des) ;
	
	boolean delete(int id);
	
	
	
	ProductModel getById(int id);
	
	ProductModel getByNamwe(String name);
	
	List<ProductModel> getAll();

}
