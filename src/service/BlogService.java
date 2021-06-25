package service;

import java.util.List;

import models.BlogModel;

public interface BlogService {
    
	void insert(BlogModel blog);
	
	void delete(BlogModel blog);
	
	void edit(BlogModel blog);
	
	List<BlogModel> getAll();
}
