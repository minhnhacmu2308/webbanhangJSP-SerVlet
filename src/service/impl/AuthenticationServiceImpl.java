package service.impl;

import Dao.Admin.AuthenticationDao;
import Dao.impl.AuthenticationDaoImpl;
import service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService{

	AuthenticationDao  auth = new AuthenticationDaoImpl(); 
	@Override
	public boolean login(String username, String password) {
		
		return auth.login(username, password);
	}
	public static void main(String[] args) {
		AuthenticationServiceImpl a = new AuthenticationServiceImpl();
		System.out.println(a.login("Admin", "admin123"));
	}

}
