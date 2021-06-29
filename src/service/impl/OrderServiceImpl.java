package service.impl;

import java.util.List;

import Dao.Admin.OrderDao;
import Dao.impl.OrderDaoImpl;
import models.OrderModel;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	
	OrderDao order = new OrderDaoImpl();
	@Override
	public boolean delete(int id) {
		
		return order.delete(id);
		
	}

	@Override
	public List<OrderModel> getAll() {
		// TODO Auto-generated method stub
		
		
		
		return order.getAll();
	}

	@Override
	public OrderModel getOrderById(int id) {
		// TODO Auto-generated method stub
		return order.getOrderById(id);
	}

	@Override
	public boolean payment(int id) {
		// TODO Auto-generated method stub
		return order.payment(id);
	}



}
