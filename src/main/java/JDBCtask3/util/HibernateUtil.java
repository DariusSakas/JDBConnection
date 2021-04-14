package JDBCtask3.util;


import JDBCtask3.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        //aprasom configuration, jei nera esancios sesijos, sukurti nauja
        if (sessionFactory == null){

            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/departments?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "admin");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop"); //update, create-drop, create

            configuration.setProperties(properties);
            //Surasyti entity klases
            configuration.addAnnotatedClass(Person.class);

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
