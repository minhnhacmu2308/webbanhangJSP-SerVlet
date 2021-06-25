package service.impl;

import java.util.List;

import Dao.Admin.CategoryDao;
import Dao.impl.CategogyDaoImpl;
import models.CategoryModel;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	CategoryDao category = new CategogyDaoImpl();

	@Override
	public boolean insert(String catName , int pat) {
		// TODO Auto-generated method stub
		return category.insert(catName, pat);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return category.delete(id);
	}

	@Override
	public boolean eidt(int id,String catName) {
		// TODO Auto-generated method stub
		return category.eidt(id, catName);
		
	}

	@Override
	public CategoryModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryModel getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		// TODO Auto-generated method stub
		return category.getAll();
	}
	
}
