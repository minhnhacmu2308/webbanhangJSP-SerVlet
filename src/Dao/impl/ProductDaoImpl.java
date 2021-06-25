package Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AbstractDao;
import Dao.Admin.ProductDao;
import models.ProductModel;
import utils.ConnectToDatabase;

public class ProductDaoImpl extends AbstractDao implements ProductDao {

	
	Connection conn = ConnectToDatabase.getConnect();
	@Override
	public boolean insert(ProductModel product) {
		
		String sql = "INSERT INTO `product`(`product_name`, `product_describe`, `picture`, `cat_id`, `price`) VALUES (?,?,?,?,?)";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,product.getProductName());
			ps.setString(2, product.getProductDescription());
			ps.setString(3, product.getProductPicture());
			ps.setInt(4,product.getCategoryId());
			ps.setFloat(5, product.getProductPrice());
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

	@Override
	public boolean edit(int id,String nameP,float price,String des) {
        String sql = "UPDATE `product` SET product_name = ?, price = ?  ,product_describe = ? WHERE product_id=?";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nameP);
			ps.setFloat(2, price);
			ps.setString(3, des);
			ps.setInt(4, id);
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
	public boolean delete(int id) {
		String sql = "DELETE FROM `product` WHERE product_id=?";
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
	public ProductModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel getByNamwe(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> getAll() {
		// TODO Auto-generated method stub
		 List<ProductModel> list = new ArrayList<>();
		 
		 String sql = "select * from product";
		 
		 try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new  ProductModel(
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

	

	
	

}
