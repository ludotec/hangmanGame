package dao;

import java.util.List;

public interface DAOi<T> 
{
	public T get(Integer id);
	public boolean delete(T o);
	public boolean save(T o);
	public boolean update(T o);
	public List<T> list();
	public List<T> list(int inicio, int fin);

}
