package Dao.Admin;

import java.util.List;

import models.UserModel;

public interface UserDao {
	
	void delete(UserModel user);
	
	void eidt(UserModel user);
	
	void insert(UserModel user);
	
	List<UserModel> getAll();
	

}
