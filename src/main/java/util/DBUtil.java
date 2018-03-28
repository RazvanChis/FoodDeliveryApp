package util;

import model.User;
import model.UserAddress;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.util.Properties;

public class DBUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure(new File("D:/Proiecte/FoodDelivery/src/main/resources/hibernate.cfg.xml"));
        configuration.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserAddress.class);
        Properties properties = configuration.getProperties();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
