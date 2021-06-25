package Dao.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import Dao.AbstractDao;
import Dao.Admin.AuthenticationDao;
import utils.ConnectToDatabase;

public class AuthenticationDaoImpl extends AbstractDao implements AuthenticationDao{

	
	Connection conn = ConnectToDatabase.getConnect();
	@Override
	public boolean login(String username, String password) {
		int result = 0;
		String sql = "select count(*) from users where user_name = ? and password = ? and isAdmin = 1";
		
		try {
			String passwordMd5 = md5(password);
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,passwordMd5);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
				if(result == 1) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public String md5(String str) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1,digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
