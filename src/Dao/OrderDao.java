package Dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.ItemModel;
import models.OrderModel;
import models.ProductModel;
import models.UserModel;
import utils.ConnectToDatabase;

public class OrderDao extends AbstractDao{
	Connection conn = ConnectToDatabase.getConnect();
	public OrderDao() {
		super();
	}
	
	 public boolean addOrder(OrderModel obj,String keyCreate) {
			int result = 0;
			String sql = "insert into orders(customerId,item,status,phoneNumber,address,methodDelivery,paymentDelivery,total,keyCreate) values(?,?,?,?,?,?,?,?,?)";
			
			try {
				String listItem = obj.getItems().toString();
				
				ps = conn.prepareStatement(sql);
				ps.setInt(1, obj.getCustomerId());
				ps.setString(2,listItem);
				ps.setBoolean(3, false);
				ps.setString(4,obj.getPhoneNumber());
				ps.setString(5,obj.getAddress());
				ps.setInt(6, obj.getMethodDelivery());
				ps.setInt(7, obj.getPaymentdelivery());
				ps.setFloat(8, obj.getTotal());
				ps.setString(9,keyCreate);
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
	 
	
	 
	 public int getOrderId(String keyCreate) {
		 String sql = "select orderId from orders where keyCreate = ?";
		 
		 try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, keyCreate);
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
	 
	 public boolean addItem(ItemModel obj,int userId,int orderId) {
		 int result=0;
		 String sql = "insert into items(productId,quantity,price,customerId,orderId) values(?,?,?,?,?)";
		 
		 try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getProduct().getProductId());
			ps.setInt(2, obj.getQuantity());
			ps.setFloat(3, obj.getPrice());
			ps.setInt(4, userId);
			ps.setInt(5, orderId);
			result= ps.executeUpdate();
			if(result==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;
	 }
	 public List<OrderModel> getListOrder(int userId){
		 List<OrderModel> list = new ArrayList<>();
		 
		 String sql ="select * from orders where customerId = ?";
		 
		 try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new OrderModel(rs.getInt(1),rs.getInt(2),rs.getBoolean(4),rs.getFloat(10),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return list;
	 }
	 
	
	public OrderModel  getListOrderById(int orderId) {
		String sql = "select * from orders as a inner join  items as it on a.orderId = it.orderId INNER JOIN product as p ON p.product_id = it.productId WHERE a.orderId=? ";
		List<ItemModel> listItem = new ArrayList<>();
		List<ProductModel> listProdcut = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
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
	
	public String getArrayProductId() {
		String sql = "select arrayproductId from orders where orderId=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 65);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	public ArrayList<String> handleArray(String orderL){
	
		String msg1 = orderL.substring(1);
		System.out.println(msg1);
		String msg2 = msg1.replaceFirst("]","");
		System.out.println(msg2);
		ArrayList<String> list = new ArrayList<>(Arrays.asList(msg2.split(", ")));
		return list;
	}
	public static void main(String[] args) {
		OrderDao or = new OrderDao();
		String msg = or.getArrayProductId();
		OrderModel a= or.getListOrderById(72);
		System.out.println(a);
		
		
	}
}
