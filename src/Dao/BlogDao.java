package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectToDatabase;

import models.BlogModel;
import models.CommentModel;

public class BlogDao extends AbstractDao{
	Connection conn = ConnectToDatabase.getConnect();
	
	public List<BlogModel> getAllBlog(){
		List<BlogModel> list = new ArrayList<>();
		
		String sql = "select * from blogs";
		
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
	public List<CommentModel> getCommentById(int blogId){
		List<CommentModel> list = new ArrayList<>();
		
		String sql = "SELECT * FROM `comments` WHERE blog_id =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, blogId);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CommentModel(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public List<BlogModel> getAllBlogAndComment(int blogId){
		List<BlogModel> list = new ArrayList<>();
		String sql = "SELECT * FROM blogs where blog_id=?";
		List<CommentModel> listC = getCommentById(blogId);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, blogId);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				list.add(new BlogModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),listC));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	public boolean addComment(int userId,int blogId,String comment) {
		String sql = "insert into comments(user_id,blog_id,comment) values(?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, blogId);
			ps.setString(3,comment);
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
	public int getNumberComment(int blogId) {
		String sql = "select count(*) from comments where blog_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, blogId);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	public static void main(String[] args) {
		BlogDao a = new BlogDao();
		List<BlogModel> list = a.getAllBlogAndComment(1);
		for(BlogModel b:list) {
			System.out.println(b.toString());
		}
		System.out.println(a.addComment(56, 2, "ok anh em"));
	}
}
