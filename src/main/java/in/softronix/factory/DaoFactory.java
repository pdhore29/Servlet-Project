package in.softronix.factory;

import in.softronix.dao.StudentDao;
import in.softronix.dao.StudentDaoImpl;

public class DaoFactory {
private static StudentDao dao=null;
	
	static 
	{
		dao=new StudentDaoImpl();
		
	}
	public static StudentDao getDao()
	{
		return dao;
	}

}
