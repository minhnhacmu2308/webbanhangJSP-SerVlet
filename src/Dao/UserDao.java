package Dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import utils.ConnectToDatabase;

public class UserDao extends AbstractDao {
	Connection conn = ConnectToDatabase.getConnect();
	
	
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
	public String getPassWordOld(int idUser)  {
		
		String sql = "SELECT password from users WHERE user_id =?";
		  
		  try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return "loi";
	}

	public boolean changePassword(int idUser,String passWordOld,String passWordNew) {
		
		int result = 0;
		String passWordMD5 = md5(passWordOld);
		
		String passWord = getPassWordOld(idUser);
		
		String passWordNewMD5 = md5(passWordNew);
		
		if(passWordMD5.equalsIgnoreCase(passWord)) {
			String sql = "update users set password=? where user_id =?";
			
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,passWordNewMD5);
				ps.setInt(2, idUser);
				result = ps.executeUpdate();
				if(result == 1) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
	
	
	public boolean editProfile(int idUser,String fullname, String numberPhone,String address) {
		
		String sql = "update users set full_name=? ,phone=?,address=? where user_id=?";
		int result=0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,fullname);
			ps.setString(2,numberPhone);
			ps.setString(3,address);
			ps.setInt(4, idUser);
			result = ps.executeUpdate();
			if(result==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	public String getFullName(int userId) {
		String sql = "select full_name from users where user_id = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs =ps.executeQuery();
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		UserDao a = new UserDao();
		System.out.println(a.getPassWordOld(56));
	}
}
