package Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AbstractDao;
import Dao.Admin.BlogDao;
import models.BlogModel;
import utils.ConnectToDatabase;

public class BlogDaoImpl extends AbstractDao implements BlogDao{

	
	Connection conn = ConnectToDatabase.getConnect();
	
	@Override
	public boolean insert(BlogModel blog) {
		String sql = "INSERT INTO `blogs`( `title`, `author`, `image`, `detail`) VALUES (?,?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,blog.getTitle() );
			ps.setString(2, blog.getAuthor());
			ps.setString(3, blog.getImage());
			ps.setString(4, blog.getDetail());
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
	public boolean delete(int id) {
	
		int result = 0 ;
		String sql = "DELETE FROM `blogs` WHERE blog_id = ?";
		
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
	public boolean edit(BlogModel blog) {
		String sql = "UPDATE `blogs` SET `title`=?,`author`=?,`image`=?,`detail`=? WHERE blog_id = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,blog.getTitle() );
			ps.setString(2, blog.getAuthor());
			ps.setString(3, blog.getImage());
			ps.setString(4, blog.getDetail());
			ps.setInt(5, blog.getBlogId());
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
	public List<BlogModel> getAll() {
		
		List<BlogModel> list = new ArrayList<>();
		
		String sql = "SELECT * FROM `blogs`";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
					list.add(new BlogModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		BlogDaoImpl a = new BlogDaoImpl();
		System.out.println(a.getAll());
	}

}
