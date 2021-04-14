package HibernateTask2;

import HibernateTask1.util.HibernateUtility;
import HibernateTask2.model.Person;
import HibernateTask2.model.Phone;
import HibernateTask2.util.HibernateTask2Utility;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateTask2Utility.getSessionFactory().openSession();
        session.beginTransaction();

        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();
        phone1.setName("Iphone 11");
        phone2.setName("Iphone 12");
        phone3.setName("Iphone SE2");

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        person1.setName("Igariok1");
        person2.setName("Igariok2");
        person3.setName("Igariok3");
        person1.setPhone(phone1);
        person2.setPhone(phone2);
        person3.setPhone(phone3);

        //session.save(book); po cascade = CascadeType.All issaugoma arba istrinama viskas
        session.save(person1);
        session.save(person2);
        session.save(person3);
        session.getTransaction().commit();

        Person personFromDB1 = session.find(Person.class, 1L);
        System.out.println(personFromDB1);
        Person personFromDB2 = session.find(Person.class, 2L);
        System.out.println(personFromDB2);
        Person personFromDB3 = session.find(Person.class, 3L);
        System.out.println(personFromDB3);
    }
}
