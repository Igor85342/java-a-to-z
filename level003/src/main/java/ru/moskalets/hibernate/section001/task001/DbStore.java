package ru.moskalets.hibernate.section001.task001;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbStore implements AutoCloseable {
    private static final DbStore INSTANCE = new DbStore();
    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private <T> T tx(final Function<Session, T> command) {
        Session session = this.factory.openSession();
        session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }


    public static DbStore getInstance() {
        return INSTANCE;
    }

    public void updateItem(Item item) {
        this.tx(
                session ->  {
                    session.update(item);
                    return true;
                }
        );
    }

    public void deleteItem(Item item) {
        this.tx(
                session ->  {
                    session.delete(item);
                    return true;
                }
        );
    }

    public List<Item> getAllItems() {
        return this.tx(
                session -> session.createQuery("from Item").list()
        );
    }

    public void addItem(Item item) {
        this.tx(session ->  session.save(item));
    }

    @Override
    public void close() {
        this.factory.close();
    }

}