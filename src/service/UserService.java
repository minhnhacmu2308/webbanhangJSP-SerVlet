package service;

import java.util.List;

import models.UserModel;

public interface UserService {

void delete(UserModel user);
	
	void eidt(UserModel user);
	
	void insert(UserModel user);
	
	List<UserModel> getAll();
	
	String getFullName(int id);
	
}
