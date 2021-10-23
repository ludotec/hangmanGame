	package dao;

import java.util.List;

import modelo.Palabra;
import org.hibernate.Session;

import util.DBUtil;

public class PalabraDAO extends EntityDAO<Palabra>{

	public Palabra buscarPorIdPalabra(Integer idP)
	{
		//Declaro una referencia del tipo Palabra y la instancio con null
		Palabra palabra = null;
		//Obtengo la sesion de la BD
		session = DBUtil.obtenerSesion();
		/*
		 * El try intenta resolver lo que esta entre llaves, en caso de fallar 
		 * en caso de fallar se ejecuta lo que está dentro del catch. Este proceso
		 * se lo conoce como manejo de excepciones en Java. Lo que se encuentra dentro 
		 * del finally se ejecuta siempre, es decir, pase lo que pase la sesion de la
		 * BD se cierra
		 */
		try
		{
			/*
			 * Consulta sobre la BD, basicamente es un select * from Palabra where idPalabra
			 * es igual al id que le pasamos por parametro
			 * */
			palabra = (Palabra) session.createQuery("from Palabra where palabra.idPalabra = :idPalabra")
					.setParameter("idPalabra", idP)
					.getSingleResult();
		}
		catch (Exception e) 
		{
			//imprime por consola el error
			e.printStackTrace();
		}
		finally 
		{
			//cierro la sesion
			session.close();
		}
		return palabra;
	}
	
	@Override
	public Palabra get(Integer id)
	{
		//Declaro una referencia del tipo Palabra y la instancio con null
		Palabra palabra = null;
		//Obtengo la sesion de la BD
		session = DBUtil.obtenerSesion();
		/*
		 * El try intenta resolver lo que esta entre llaves, en caso de fallar 
		 * en caso de fallar se ejecuta lo que está dentro del catch. Este proceso
		 * se lo conoce como manejo de excepciones en Java. Lo que se encuentra dentro 
		 * del finally se ejecuta siempre, es decir, pase lo que pase la sesion de la
		 * BD se cierra
		 */
		try
		{
			/*
			 * Consulta sobre la BD, basicamente es un select * from Palabra where idPalabra
			 * es igual al id que le pasamos por parametro
			 * */
			palabra = (Palabra) session.createQuery("from Palabra p where p.idPalabra = :idPalabra")
					.setParameter("idPalabra", id)
					.getSingleResult();
		}
		catch (Exception e) 
		{
			//imprime por consola el error
			e.printStackTrace();
		}
		finally 
		{
			//cierro la sesion
			session.close();
		}
		return palabra;
	}

	@Override
	public boolean delete(Palabra o)
	{
		boolean ok = true;
		session = DBUtil.obtenerSesion();
		try
		{
			/*
			 * Transaccion que intenta eliminar de la BD el objeto o.
			 * Basicamente es un delete from Palabra where idPalabra es
			 * igual al id del objeto que pasamos por parametro.
			 */
			session.beginTransaction();
			session.delete(o);
			session.getTransaction().commit();
		}
		catch (Exception e) 
		{
			//En caso de fallar el borrado, se vuelve todo para atras.
			if(session.getTransaction() != null)
			{
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			ok = false;
		}
		finally {
			//cierro la sesion
			session.close();
		}
		return ok;
	}

	@Override
	public boolean save(Palabra o) {
		boolean ok = true;
		session = DBUtil.obtenerSesion();
		try
		{
			/*
			 * Transaccion que intenta insertar un registro en la tabla
			 * Palabra, es un insert into Palabra .... todos los valores
			 * que contiene el objeto que le pasamos por parametro
			 */
			session.beginTransaction();
			session.save(o);
			session.getTransaction().commit();
		}
		catch (Exception e) 
		{
			if(session.getTransaction() != null)
			{
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			ok = false;
		}
		finally {
			//cierro la sesion
			session.close();
		}
		return ok;
	}

	@Override
	public boolean update(Palabra o) {
		boolean ok = true;
		Session session = DBUtil.obtenerSesion();
		try
		{
			/*
			 * Transaccion que intenta actualizar un registro en la tabla
			 * Palabra, es un update Palabra .... todos los valores
			 * que contiene el objeto que le pasamos por parametro
			 * where idPalabra es el id del objeto
			 */
			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit();
		}
		catch (Exception e) 
		{
			if(session.getTransaction() != null)
			{
				session.getTransaction().rollback();
			}
			e.printStackTrace();
			ok = false;
		}
		finally {
			//cierro la sesion
			session.close();
		}
		return ok;
	}

	@Override
	public List<Palabra> list()
	{
		List<Palabra> listaPalabras = null;
		session = DBUtil.obtenerSesion();
		try
		{
			/*
			 * Listado de todos los registros de la tabla Palabra.
			 * Basicamente es un select * from Palabra
			 */
			listaPalabras = session.createQuery("from Palabra").getResultList();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//cierro la sesion
			session.close();
		}
		return listaPalabras;
	}
	
	@Override
	public List<Palabra> list(int inicio, int fin)
	{
		List<Palabra> listaPalabras = null;
		session = DBUtil.obtenerSesion();
		try
		{
			/*
			 * Listado paginado de los registros de la tabla Palabra.
			 * Basicamente es un select * from Palabra desde "inicio"
			 * hasta "fin"
			 */
			listaPalabras = session.createQuery("from Palabra")
					.setFirstResult(inicio)
					.setMaxResults(fin-inicio)
					.getResultList();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//cierro la sesion
			session.close();
		}
		return listaPalabras;
	}

	

}
