package service.impl;

import java.util.List;

import Dao.Admin.BlogDao;
import Dao.impl.BlogDaoImpl;
import models.BlogModel;
import service.BlogService;

public class BlogServiceImpl implements BlogService{

	
	BlogDao blogS = new BlogDaoImpl();

	@Override
	public boolean insert(BlogModel blog) {
		// TODO Auto-generated method stub
		return blogS.insert(blog);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return blogS.delete(id);
	}

	@Override
	public boolean edit(BlogModel blog) {
		// TODO Auto-generated method stub
		return blogS.edit(blog);
	}

	@Override
	public List<BlogModel> getAll() {
		// TODO Auto-generated method stub
		return blogS.getAll();
	}

}
