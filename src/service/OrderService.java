package service;

import java.util.List;


import models.OrderModel;

public interface OrderService {
	
	void delete(int id);
	
	 List<OrderModel> getAll();
}
