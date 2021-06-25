package Dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.AbstractDao;
import Dao.Admin.OrderDao;
import models.OrderModel;
import utils.ConnectToDatabase;

public class OrderDaoImpl extends AbstractDao implements OrderDao {
	
	Connection conn = ConnectToDatabase.getConnect();

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from orders where orderId = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderModel> getAll() {
		
		// TODO Auto-generated method stub
		String sql = "select & from orders";
		List<OrderModel> list= new ArrayList<OrderModel>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
