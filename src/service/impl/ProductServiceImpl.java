package service.impl;

import java.util.List;


import Dao.Admin.ProductDao;
import Dao.impl.ProductDaoImpl;
import models.ProductModel;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productD = new ProductDaoImpl();
	
	

	@Override
	public boolean edit(int id,String nameP,float price,String des) {
		// TODO Auto-generated method stub
		return productD.edit(id, nameP, price, des);
	}

	@Override
	public boolean delete(int  id) {
		// TODO Auto-generated method stub
		return productD.delete(id);
	}

	@Override
	public ProductModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel getByNamwe(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAll() {
		// TODO Auto-generated method stub
		return productD.getAll();
	}
	
	public static void main(String[] args) {
		ProductServiceImpl a  = new ProductServiceImpl();
		System.out.println(a.getAll());
	}

	@Override
	public boolean insert(ProductModel product) {
		// TODO Auto-generated method stub
		return productD.insert(product);
	}

	
	

}
