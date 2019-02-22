package ru.moskalets.hibernate.section002.task001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.moskalets.hibernate.section001.task001.Item;

import java.util.List;
import java.util.function.Function;

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

    public void addCar(Car car) {
        this.tx(session ->  session.save(car));
    }

    public List<Car> getAllCarsXML() {
        return this.tx(
                session -> session.createQuery("from CarXML").list()
        );
    }

    public List<Car> getAllCarsAnnotations() {
        return this.tx(
                session -> session.createQuery("from CarAnnotations ").list()
        );
    }

    public void updateCar(Car car) {
        this.tx(
                session ->  {
                    session.update(car);
                    return true;
                }
        );
    }

    public void deleteCar(Car car) {
        this.tx(
                session ->  {
                    session.delete(car);
                    return true;
                }
        );
    }

    public CarXML getCarXML(int id) {
        Session session = this.factory.openSession();
        session.beginTransaction();
        CarXML result;
        try {
            result = session.get(CarXML.class, id);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.getTransaction().commit();
           session.close();
        }
        return result;
    }

    public void deleteTableCar() {
        this.tx(
                session ->  {
                    session.createSQLQuery("drop table cars;").executeUpdate();
                    session.createSQLQuery("create table cars(\n"
                            + "\tid serial primary key,\n"
                            + "\tid_carbody int not null references carbodyes(id),\n"
                            + "\tid_motor int not null references motors(id),\n"
                            + "\tid_transmission int not null references transmissions(id)\n"
                            + ");").executeUpdate();
                    return true;
                }
        );
    }

    @Override
    public void close() {
        this.factory.close();
    }
}