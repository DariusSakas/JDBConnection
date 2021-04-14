package HibernateTask1;

import HibernateTask1.model.Book;
import HibernateTask1.model.Owner;
import HibernateTask1.util.HibernateUtility;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        Book book = new Book();
        book.setTitle("LOTR");

        Owner owner = new Owner();
        owner.setCountry("Latvia");
        owner.setName("Jefferson");
        owner.setBook(book);

        //session.save(book); po cascade = CascadeType.All issaugoma arba istrinama viskas
        session.save(owner);
        session.getTransaction().commit();

        Owner ownerFromDb = session.find(Owner.class, 1L);
        System.out.println(ownerFromDb);

    }
}
