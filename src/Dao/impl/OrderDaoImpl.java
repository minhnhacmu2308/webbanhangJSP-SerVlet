package Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AbstractDao;
import Dao.Admin.OrderDao;
import models.ItemModel;
import models.OrderModel;
import models.ProductModel;
import utils.ConnectToDatabase;

public class OrderDaoImpl extends AbstractDao implements OrderDao {
	
	Connection conn = ConnectToDatabase.getConnect();

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from orders where orderId = ?";
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
	public List<OrderModel> getAll() {
		
		// TODO Auto-generated method stub
		String sql = "select * from orders";
		List<OrderModel> list= new ArrayList<OrderModel>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				list.add(new OrderModel(rs.getInt(1),rs.getInt(2),rs.getBoolean(4),rs.getFloat(10),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public OrderModel getOrderById(int id) {
		String sql = "select * from orders as a inner join  items as it on a.orderId = it.orderId INNER JOIN product as p ON p.product_id = it.productId WHERE a.orderId=? ";
		List<ItemModel> listItem = new ArrayList<>();
		List<ProductModel> listProdcut = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			OrderModel order = new OrderModel();
			while(rs.next()) {
				ProductModel pd = new ProductModel(rs.getInt(13),rs.getString(19),rs.getString(20),rs.getString(21),rs.getInt(22),rs.getFloat(24));
				listProdcut.add(pd);
				listItem.add(new ItemModel(rs.getInt(16),rs.getInt(13),pd,rs.getInt(14),rs.getFloat(15)));
				
				order.setOrderId(rs.getInt(1));
				order.setCustomerId(rs.getInt(2));
				order.setItems(listItem);
				order.setStatus(rs.getBoolean(4));
				order.setPhoneNumber(rs.getString(6));
				order.setAddress(rs.getString(7));
				order.setMethodDelivery(rs.getInt(8));
				order.setPaymentdelivery(rs.getInt(9));
				order.setTotal(rs.getFloat(10));
				order.setCreateTime(rs.getString(5));
				
			}
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean payment(int id) {
		
		String sql = "update orders set status = ? where orderId = ?";
		int result = 0;
		
		try {
			ps =conn.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, id);
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
	

}
