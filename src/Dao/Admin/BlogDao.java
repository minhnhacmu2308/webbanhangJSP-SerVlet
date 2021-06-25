package Dao.Admin;

import java.util.List;

import models.BlogModel;

public interface BlogDao {
	void insert(BlogModel blog);
	
	void delete(BlogModel blog);
	
	void edit(BlogModel blog);
	
	List<BlogModel> getAll();
	
}
