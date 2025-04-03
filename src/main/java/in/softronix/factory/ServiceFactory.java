package in.softronix.factory;

import in.softronix.service.StudentService;
import in.softronix.service.StudentServiceImpl;

public class ServiceFactory {
private static StudentService service=null;
	
	static
	{
		service=new StudentServiceImpl();
	}
	
	public static StudentService getService()
	{
		return service;
		
	}

}
