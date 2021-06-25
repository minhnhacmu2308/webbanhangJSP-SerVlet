package Dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import models.UserModel;
import utils.ConnectToDatabase;

public class AuthenticationDao extends AbstractDao {
	
	Connection conn = ConnectToDatabase.getConnect();
	
	public AuthenticationDao() {};
	
	public boolean checkAccountExit(String userName) {
		int result = 0;
		String sql = "select count(*) from users where user_name = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,userName);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				result = rs.getInt(1);
				if(result==1) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public String md5(String str){
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
	
	public boolean register(String userName, String password,String fullName, String phoneNumber, String address) {
		
		
	    String sql = "INSERT INTO users(user_name,password,full_name,phone,address,isSell,isAdmin) VALUES(?,?,?,?,?,0,0)";
	    
	    try {
	    	String passwordMd5 = md5(password);
	    	int result = 0;
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passwordMd5);
			ps.setString(3, fullName);
			ps.setString(4, phoneNumber);
			ps.setString(5, address);
			result = ps.executeUpdate();
			System.out.println(result);
			if(result==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean checkLogin(String userName, String password ) {
		
		int result = 0;
		String sql = "select count(*) from users where user_name = ? and password = ?";
		
		try {
			String passwordMd5 = md5(password);
			ps = conn.prepareStatement(sql);
			ps.setString(1,userName);
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
	
	public UserModel getInformationUser(String userName) {
		
		String sql = "select * from users where user_name = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new UserModel(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		AuthenticationDao a = new AuthenticationDao();
		Boolean user = a.checkLogin("minhnha12","123456789");
		UserModel abc= a.getInformationUser("minhnha12");
		System.out.println(abc);
		
	}
}
