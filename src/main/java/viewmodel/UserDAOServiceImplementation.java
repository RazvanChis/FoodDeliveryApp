package viewmodel;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;
import util.DBUtil;

public class UserDAOServiceImplementation implements UserDAOService {

	SessionFactory sessionFactory;

	public UserDAOServiceImplementation() {
		this.sessionFactory = DBUtil.configureSessionFactory();
	}

	@Override
	public boolean addUser(User user) {
		boolean successfull = true;
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			successfull = true;

		} catch (HibernateException e) {
			successfull = false;
			System.out.print(e);
		}
		return successfull;
	}

	@Override
	public void deleteUser(String userId) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete User where CNP=:id");
			query.setParameter("id", userId);
			query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			System.out.print(e);
		}
	}

	@Override
	public User getUser(String userName, String password) {
		Session session = sessionFactory.openSession();

		String queryString = "FROM User WHERE username=:username AND password=:password";
		Query query = session.createQuery(queryString);
		query.setParameter("username", userName);
		query.setParameter("password", password);

		User user = null;
		try {
			user = (User) query.uniqueResult();
		} catch (Exception e) {
		}
		return user;
	}

	@Override
	public User getUserByUsername(String userName) {
		Session session = sessionFactory.openSession();

		String queryString = "FROM User WHERE username=:username";
		Query query = session.createQuery(queryString);
		query.setParameter("username", userName);

		User user = null;
		try {
			user = (User) query.uniqueResult();
		} catch (Exception e) {
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();

		String queryString = "FROM User WHERE email=:email";
		Query query = session.createQuery(queryString);
		query.setParameter("email", email);

		User user = null;
		try {
			user = (User) query.uniqueResult();
		} catch (Exception e) {
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> getAllUsers() {
		Session session = sessionFactory.openSession();

		String queryString = "FROM User";
		Query query = session.createQuery(queryString);

		ArrayList<User> users = new ArrayList<User>();
		try {
			users = (ArrayList<User>) query.list();
		} catch (Exception e) {
		}
		return users;
	}

	@Override
	public boolean updateUser(User user) {
		boolean successfull = true;
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(
					"UPDATE User SET username=:username, firstname=:firstname, lastname=:lastname, email=:email, country=:country, county=:county, city=:city, street=:street, streetnumber=:streetnumber WHERE CNP=:CNP");
			query.setParameter("CNP", user.getCnp());
			query.setParameter("username", user.getUsername());
			query.setParameter("firstname", user.getFirstName());
			query.setParameter("lastname", user.getLastName());
			query.setParameter("email", user.getEmail());
			query.setParameter("country", user.getCountry());
			query.setParameter("county", user.getCounty());
			query.setParameter("city", user.getCity());
			query.setParameter("street", user.getStreet());
			query.setParameter("streetnumber", user.getStreetNumber());
			query.executeUpdate();
			successfull = true;

		} catch (HibernateException e) {
			successfull = false;
			System.out.print(e);
		}
		return successfull;
	}

}
