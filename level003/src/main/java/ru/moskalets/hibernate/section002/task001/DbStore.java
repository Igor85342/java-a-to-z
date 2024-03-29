package ru.moskalets.hibernate.section002.task001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Calendar;
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
        return this.tx(
                session -> session.get(CarXML.class, id)
        );

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

    public void addCategory(Category category) {
        this.tx(session ->  session.save(category));
    }

    public List<Category> getAllCategories() {
        return this.tx(
                session -> session.createQuery("from Category").list()
        );
    }

    public void addBrand(Brand brand) {
        this.tx(session ->  session.save(brand));
    }

    public List<Brand> getAllBrands() {
        return this.tx(
                session -> session.createQuery("from Brand").list()
        );
    }

    public void addCarbody(CarbodyXML carbody) {
        this.tx(session ->  session.save(carbody));
    }

    public List<CarbodyXML> getAllCarbodyes() {
        return this.tx(
                session -> session.createQuery("from CarbodyXML").list()
        );
    }

    public void addMotor(MotorXML motor) {
        this.tx(session ->  session.save(motor));
    }

    public List<MotorXML> getAllMotors() {
        return this.tx(
                session -> session.createQuery("from MotorXML").list()
        );
    }

    public void addTransmission(TransmissionXML transmission) {
        this.tx(session ->  session.save(transmission));
    }

    public List<TransmissionXML> getAllTransmissions() {
        return this.tx(
                session -> session.createQuery("from TransmissionXML").list()
        );
    }

    public void addUser(User user) {
        this.tx(session ->  session.save(user));
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

    public User getUserById(int id) {
        return this.tx(
                session -> {
                    Query query = session.createQuery("from User where id = :id");
                    query.setParameter("id", id);
                    return (User) query.getSingleResult();
                }
        );
    }

    public List<CarXML> getCarWithImage() {
        return this.tx(
                session -> {
                    Query query = session.createQuery("from CarXML c where c.imageBase64 != :imageBase64");
                    query.setParameter("imageBase64", "");
                    List<CarXML> list = query.getResultList();
                    return list;
                }
        );
    }

    public List<CarXML> getCarWithBrand(int brand) {
        return this.tx(
                session -> {
                    Query query = session.createQuery("from CarXML c where c.brand.id = :brand");
                    query.setParameter("brand", brand);
                    List<CarXML> list = query.getResultList();
                    return list;
                }
        );
    }

    public List<CarXML> getCarLastDay() {
        return this.tx(
                session -> {
                    long now = new Timestamp(System.currentTimeMillis()).getTime();
                    Query query = session.createQuery("from CarXML c WHERE c.date >= :lastDay and c.date <= :now");
                    query.setParameter("lastDay", getLastDay(now));
                    query.setParameter("now", now);
                    List<CarXML> list = query.getResultList();
                    return list;
                }
        );
    }

    @Override
    public void close() {
        this.factory.close();
    }

    public long getLastDay(long now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(now));
        cal.add(Calendar.DATE, -1);
        return cal.getTimeInMillis();
    }
}