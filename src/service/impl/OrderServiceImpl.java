package service.impl;

import java.util.List;

import Dao.Admin.OrderDao;
import Dao.impl.OrderDaoImpl;
import models.OrderModel;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	
	OrderDao order = new OrderDaoImpl();
	@Override
	public void delete(int id) {
		order.delete(id);
		
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}
