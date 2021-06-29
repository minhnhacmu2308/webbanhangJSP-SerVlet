package Dao.Admin;

import java.util.List;

import models.OrderModel;

public interface OrderDao {
	
	boolean delete(int  id);
	
	List<OrderModel> getAll();
	
	OrderModel getOrderById(int id);
	
	boolean payment(int id);

}
