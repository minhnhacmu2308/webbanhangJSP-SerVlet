package Dao.Admin;

import java.util.List;

import models.BlogModel;

public interface BlogDao {
	boolean insert(BlogModel blog);
	
	boolean delete(int id);
	
	boolean edit(BlogModel blog);
	
	List<BlogModel> getAll();
	
}
