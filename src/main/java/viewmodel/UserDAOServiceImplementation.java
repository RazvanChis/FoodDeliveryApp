package viewmodel;

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
		}
		return successfull;
	}

	@Override
	public void deleteUser(String userId) {

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
}
