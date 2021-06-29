package service.impl;

import java.util.List;

import Dao.Admin.UserDao;
import Dao.impl.UserdaoImpl;
import models.UserModel;
import service.UserService;

public class UserServiceImpl implements UserService{

	
	UserDao userD = new UserdaoImpl();
	
	@Override
	public void delete(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eidt(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return userD.getAll();
	}

	@Override
	public String getFullName(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
