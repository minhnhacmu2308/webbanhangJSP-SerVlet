package Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AbstractDao;
import Dao.Admin.CategoryDao;
import models.CategoryModel;
import utils.ConnectToDatabase;

public class CategogyDaoImpl extends AbstractDao implements CategoryDao {
	
	Connection conn = ConnectToDatabase.getConnect();
	@Override
	public boolean insert(String catName , int pat) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `cat`( `cat_name`, `parent_id`) VALUES (?,?) ";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,catName);
			ps.setInt(2, pat);
			result = ps.executeUpdate();
			if(result == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean delete(int  id) {
		String sql = "DELETE FROM `cat` WHERE cat_id=?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			result = ps.executeUpdate();
			if(result == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eidt(int id,String catName) {
		String sql = "UPDATE `cat` SET cat_name= ? WHERE cat_id=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, catName);
			ps.setInt(2, id);
			result = ps.executeUpdate();
			if(result ==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public CategoryModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryModel getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> getAll() {
		// TODO Auto-generated method stub
		List<CategoryModel> list = new ArrayList<CategoryModel>();
        String sql = "select * from cat ";
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CategoryModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
			    ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CategoryModel> getCatPat0() {
		// TODO Auto-generated method stub
		List<CategoryModel> list = new ArrayList<CategoryModel>();
        String sql = "select * from cat where parent_id = 0";
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CategoryModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
			    ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CategoryModel> getCatPatMore0() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
        String sql = "select * from cat where parent_id > 0";
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CategoryModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
			    ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
