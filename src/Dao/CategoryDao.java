package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import models.CategoryModel;
import models.ProductModel;
import utils.ConnectToDatabase;

public class CategoryDao extends AbstractDao{
	Connection conn = ConnectToDatabase.getConnect();
	public List<CategoryModel> getAllCategory(){
		List<CategoryModel> listC = new ArrayList<>();
		String sql = "select * from cat ";
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				listC.add(new CategoryModel(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
			    ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listC;
	}
		public List<CategoryModel> getChirldCategory(int id){
			List<CategoryModel> listC = new ArrayList<>();
			String sql = "select * from cat where parent_id=?";
			try {
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					listC.add(new CategoryModel(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3)
				    ));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return listC;
		}
		public int getNumberCategory(int id){
			int numberC=0 ;
			String sql = "select count(*) from product where parent_id=?";
			try {
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					
					numberC= rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return numberC;
		}
		public List<ProductModel> getAllProduct(){
			List<ProductModel> list = new ArrayList<>();
			String sql= "select * from product limit 12";
			
			try {
				
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new ProductModel(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getFloat(6),
							rs.getInt(7),
							rs.getInt(8)
					));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		public List<ProductModel> getHotProduct(){
			List<ProductModel> list = new ArrayList<>();
			String sql= "select * from product limit 10";
			
			try {
				
				ps = conn.prepareStatement(sql);		
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new ProductModel(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getFloat(6),
							rs.getInt(7),
							rs.getInt(8)
					));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
		 public int getNumberPage(String catId) {
			  String sql = "select count(*) from product where cat_id=?"; 
			  try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,catId);
				rs = ps.executeQuery();
				while(rs.next()) {
					int total = rs.getInt(1);
					int count = 0;
					count = total/9;
					if(total % 9 != 0) {
						count++;
					}
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return 0;
		  }
		public List<ProductModel> getCategoryId(String catId,int index){
			List<ProductModel> list = new ArrayList<>();
			String sql = "select * from product where cat_id=? limit ?,?";
			try {
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, catId);
				ps.setInt(2, (index-1)*9);
				ps.setInt(3, 9);
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new ProductModel(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getInt(5),
							rs.getFloat(6),
							rs.getInt(7),
							rs.getInt(8)
					));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
		}
	public static void main(String[] args) {
		CategoryDao test = new CategoryDao();
		List<ProductModel> list2 = test.getAllProduct();
		for(ProductModel p:list2) {
			System.out.println(p);
		}
	}
}
