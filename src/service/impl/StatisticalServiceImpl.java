package service.impl;

import Dao.Admin.StatisticalDao;
import Dao.impl.StatisticalDaoImpl;
import models.StatisticalModel;
import service.StatisticalService;

public class StatisticalServiceImpl implements StatisticalService{

	StatisticalDao service = new StatisticalDaoImpl();
	
	@Override
	public StatisticalModel getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}

}
