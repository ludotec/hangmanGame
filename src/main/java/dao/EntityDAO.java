package dao;

import org.hibernate.Session;

public abstract class EntityDAO<T> implements DAOi<T> {

	protected Session session;
	
}
