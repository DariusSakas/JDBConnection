package JDBCtask3.dao;

import JDBCtask3.model.Person;
import JDBCtask3.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * DATA ACCESS OBJECT
 * Reikalingas funkcijomis sveikauti su duomenu baze
 */

public class PersonDao {
    public void createPerson(Person person) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Inserting new person into database");
        session.save(person);
        transaction.commit();
    }

    public Person getPerson(Long id) {
        Person person = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            person = session.find(Person.class, id);
            return person;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return person;
    }
    public void deletePerson (Person person){
         Session session = HibernateUtil.getSessionFactory().openSession();
         //pradedam transaction
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        //uzdarom transaction
        transaction.commit();
    }
    public void updatePerson (Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
    }
    public List<Person> getPeopleByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query queryByName = session.createNamedQuery("get_person_by_name", Person.class);
        //select * from person where name like "%eda%"
        queryByName = queryByName.setParameter("name", "%"+name+"%");
        List<Person> people = queryByName.list();
        return people;
    }
}
