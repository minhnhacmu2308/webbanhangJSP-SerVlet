package Dao.impl;

import Dao.Admin.StatisticalDao;
import models.StatisticalModel;


public class StatisticalDaoImpl implements StatisticalDao {

	
	OrderDaoImpl ord = new OrderDaoImpl();
	ProductDaoImpl pro = new ProductDaoImpl();
	CategogyDaoImpl cat = new CategogyDaoImpl();
	UserdaoImpl user = new UserdaoImpl();
	@Override
	public StatisticalModel getAll() {
		StatisticalModel re = new StatisticalModel();
		
		re.setTotalCategory(cat.getAll().size());
		re.setTotalOrder(ord.getAll().size());
		re.setTotalProduct(pro.getAll().size());
		re.setTotalUser(user.getAll().size());
		return re;
	}
	
}
