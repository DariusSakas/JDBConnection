package HibernateTask2.util;


import HibernateTask1.model.Book;
import HibernateTask1.model.Owner;
import HibernateTask2.model.Person;
import HibernateTask2.model.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateTask2Utility {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        //aprasom configuration, jei nera esancios sesijos, sukurti nauja
        if (sessionFactory == null){

            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/task1?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "admin");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop"); //update, create-drop, create

            configuration.setProperties(properties);
            //Surasyti entity klases
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Phone.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory;
    }

    public static void shutDown(){
        getSessionFactory().close();
    }

}
