package Dao.Admin;

import java.util.List;

import models.OrderModel;

public interface OrderDao {
	
	void delete(int  id);
	
	 List<OrderModel> getAll();

}
