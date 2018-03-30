package viewmodel;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Product;
import util.DBUtil;

public class ProductDAOServiceImplementation implements ProductDAOService {

	SessionFactory sessionFactory;

	public ProductDAOServiceImplementation() {
		this.sessionFactory = DBUtil.configureSessionFactory();
	}

	@Override
	public boolean addProduct(Product product) {
		boolean successfull = true;
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			successfull = true;

		} catch (HibernateException e) {
			successfull = false;
			System.out.print(e);
		}
		return successfull;
	}

	@Override
	public void deleteProduct(int productId) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("delete Product where product_Id=:id");
			query.setParameter("id", productId);
			query.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			System.out.print(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> getAllProducts() {
		Session session = sessionFactory.openSession();

		String queryString = "FROM Product";
		Query query = session.createQuery(queryString);

		ArrayList<Product> products = new ArrayList<Product>();
		try {
			products = (ArrayList<Product>) query.list();
		} catch (Exception e) {
		}
		return products;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean successfull = true;
		try {
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(
					"UPDATE Product SET description=:description, name=:name, price=:price WHERE product_Id=:id");
			query.setParameter("id", product.getProductId());
			query.setParameter("description", product.getDescription());
			query.setParameter("name", product.getName());
			query.setParameter("price", product.getPrice());
			query.executeUpdate();
			successfull = true;
		} catch (HibernateException e) {
			successfull = false;
			System.out.print(e);
		}
		return successfull;
	}

}
