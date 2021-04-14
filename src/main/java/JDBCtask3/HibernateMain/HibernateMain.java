package JDBCtask3.HibernateMain;

import JDBCtask3.dao.PersonDao;
import JDBCtask3.model.Person;
import JDBCtask3.util.HibernateUtil;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {

       // HibernateUtil.getSessionFactory();
        PersonDao personDao = new PersonDao();

        Person person = new Person(null,"Henry", "Hay", "hh@mail.com", "USA");
        System.out.println("Inserting a new person into database");
        personDao.createPerson(person);

        //find person
        System.out.println(personDao.getPerson(1L));

        personDao.deletePerson(person);
        System.out.println(personDao.getPerson(1L));

        personDao.createPerson(person);
        System.out.println(person);

        person.setCountry("Macedonia");
        person.setLastName("Piotar");
        personDao.updatePerson(person);
        System.out.println(personDao.getPerson(2L));

        List<Person> people = personDao.getPeopleByName("r");
        System.out.println("Printing people with names that have 'r' ");
        people.forEach(System.out::println);
    }
}
