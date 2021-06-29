package Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AbstractDao;
import Dao.Admin.UserDao;
import models.UserModel;
import utils.ConnectToDatabase;

public class UserdaoImpl extends AbstractDao implements  UserDao{

	
	Connection conn = ConnectToDatabase.getConnect();
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
		
		String sql = "SELECT * FROM `users`";
		
		List<UserModel> list = new ArrayList<UserModel>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public UserModel findUserById(int id) {
	
		return null;
	}

	@Override
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

}
