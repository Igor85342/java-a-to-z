package ru.moskalets.hibernate.section002.task001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.io.IOException;
import java.sql.SQLException;
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

    public List<CarXML> getAllCarsXML() {
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
                            + "\tid_category int not null references categoryes(id)\n"
                            + "\tid_brand int not null references brands(id)\n"
                            + ");").executeUpdate();
                    return true;
                }
        );
    }

    public List<Category> getAllCategories() {
        return this.tx(
                session -> session.createQuery("from Category").list()
        );
    }

    public List<Brand> getAllBrands() {
        return this.tx(
                session -> session.createQuery("from Brand").list()
        );
    }

    public List<CarbodyXML> getAllCarbodyes() {
        return this.tx(
                session -> session.createQuery("from CarbodyXML").list()
        );
    }

    public List<MotorXML> getAllMotors() {
        return this.tx(
                session -> session.createQuery("from MotorXML").list()
        );
    }

    public List<TransmissionXML> getAllTransmissions() {
        return this.tx(
                session -> session.createQuery("from TransmissionXML").list()
        );
    }

    public List<User> getUsers() {
        return this.tx(
                session -> session.createQuery("from User").list()
        );
    }

    public User getUserByLogin(String login) {
        return this.tx(
                session -> {
                    Query query = session.createQuery("from User where login = :login");
            query.setParameter("login", login);
            return (User) query.getSingleResult();
                }
        );
    }
    @Override
    public void close() {
        this.factory.close();
    }
}