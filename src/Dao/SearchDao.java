package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ProductModel;
import utils.ConnectToDatabase;

public class SearchDao extends AbstractDao{
	Connection conn = ConnectToDatabase.getConnect();
	
	public int getNumberPage(String keySearch) {
		
		String sql = "select count(*) from product where product_name like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+keySearch+"%");
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
	  public List<ProductModel> pagingproduct(int index,String keySearch){
		  List<ProductModel> list = new ArrayList<>();
		  String sql = "select * from `product`where product_name like ? limit ?,?";
		  try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+keySearch+"%");
			ps.setInt(2, (index-1)*12);
			ps.setInt(3, 12);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(
				          new ProductModel(
				            rs.getInt(1),
				            rs.getString(2),
				            rs.getString(3),
				            rs.getString(4),
				            rs.getInt(5),
				            rs.getFloat(6),
				            rs.getInt(7),
				            rs.getInt(8)
				          )
				        );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return list;
	  }
	public static void main(String[] args) {
		SearchDao da = new SearchDao();
		System.out.println(da.getNumberPage("Xà lách"));
		 List<ProductModel> list = da.pagingproduct(1, "Xà lách");
		 System.out.println(list.size());
		 for(ProductModel a : list) {
			 System.out.println(a);
		 }
		
	}
}
