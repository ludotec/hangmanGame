package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtil{


	private final static SessionFactory FACTORY = new Configuration()
			.configure("src/hibernate.cfg.xml")
			.buildSessionFactory();

	public static Session obtenerSesion()
	{
		try
		{
			return FACTORY.openSession();
		}
		catch(Exception e)
		{
			if(FACTORY.getCurrentSession() != null)
			{
				try
				{
					FACTORY.getCurrentSession().close();
					return FACTORY.openSession();
				}
				catch (Exception e2) 
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static void cerrarSessionFactory()
	{
		FACTORY.close();
	}
	
	
}