package ru.moskalets.hibernate.section002.task001;

import java.util.List;

public class ValidateService {
    private static final ValidateService INSTANCE = new ValidateService();
    private final DbStore store = DbStore.getInstance();

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public List<CarXML> getAllCar() {
        return this.store.getAllCarsXML();
    }

    public void addCar(Car car) {
        this.store.addCar(car);
    }

    public void updateCar(Car car) {
        this.store.updateCar(car);
    }

    public List<Category> getAllCategories() {
        return this.store.getAllCategories();
    }

    public List<Brand> getAllBrands() {
        return this.store.getAllBrands();
    }

    public List<CarbodyXML> getAllCarbodyes() {
        return this.store.getAllCarbodyes();
    }

    public List<MotorXML> getAllMotors() {
        return this.store.getAllMotors();
    }

    public List<TransmissionXML> getAllTransmissions() {
        return this.store.getAllTransmissions();
    }

    public CarXML getCarXML(int id) {
        return this.store.getCarXML(id);
    }
    public boolean isCredentional(String login, String password) {
        boolean result = false;
        List<User> list = this.store.getUsers();
        for (User user: list) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
    public User getUserByLogin(String login) {
        return this.store.getUserByLogin(login);
    }
}