package ru.moskalets.hibernate.section002.task001;
import org.junit.Test;

import java.sql.Timestamp;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DbStoreTest {
    private final DbStore store = DbStore.getInstance();

    @Test
    public void whenAddCarXML() {
        CarXML car = new CarXML();
        this.store.addCar(car);
        assertThat(car, is(this.store.getCarXML(car.getId())));
    }

    @Test
    public void whenGetAllCarsXML() {
        CarXML car001 = new CarXML();
        this.store.addCar(car001);
        assertTrue(this.store.getAllCarsXML().contains(car001));
    }

    @Test
    public void whenUpdateCar() {
        CarXML car = new CarXML();
        car.setSold(false);
        this.store.addCar(car);
        car.setSold(true);
        this.store.updateCar(car);
        assertThat(true, is(this.store.getCarXML(car.getId()).getSold()));
    }

    @Test
    public void whenDeleteCar() {
        CarXML car = new CarXML();
        this.store.addCar(car);
        this.store.deleteCar(car);
        assertFalse(this.store.getAllCarsXML().contains(car));
    }

    @Test
    public void whenGetCarXML() {
        CarXML car = new CarXML();
        this.store.addCar(car);
        assertThat(car, is(this.store.getCarXML(car.getId())));
    }

    @Test
    public void whenAddCategory() {
        Category category = new Category();
        this.store.addCategory(category);
        assertTrue(this.store.getAllCategories().contains(category));
    }

    @Test
    public void whenGetAllCategoryes() {
        Category category = new Category();
        this.store.addCategory(category);
        assertTrue(this.store.getAllCategories().contains(category));
    }

    @Test
    public void whenAddBrand() {
       Brand brand = new Brand();
        this.store.addBrand(brand);
        assertTrue(this.store.getAllBrands().contains(brand));
    }

    @Test
    public void whenGetAllBrands() {
        Brand brand = new Brand();
        this.store.addBrand(brand);
        assertTrue(this.store.getAllBrands().contains(brand));
    }

    @Test
    public void whenAddCarbody() {
        CarbodyXML carbody = new CarbodyXML();
        this.store.addCarbody(carbody);
        assertTrue(this.store.getAllCarbodyes().contains(carbody));
    }

    @Test
    public void whenGetAllCarbodyes() {
        CarbodyXML carbody = new CarbodyXML();
        this.store.addCarbody(carbody);
        assertTrue(this.store.getAllCarbodyes().contains(carbody));
    }

    @Test
    public void whenAddMotor() {
        MotorXML motor = new MotorXML();
        this.store.addMotor(motor);
        assertTrue(this.store.getAllMotors().contains(motor));
    }

    @Test
    public void whenGetAllMotors() {
        MotorXML motor = new MotorXML();
        this.store.addMotor(motor);
        assertTrue(this.store.getAllMotors().contains(motor));
    }

    @Test
    public void whenAddTransmission() {
        TransmissionXML transmission = new TransmissionXML();
        this.store.addTransmission(transmission);
        assertTrue(this.store.getAllTransmissions().contains(transmission));
    }

    @Test
    public void whenGetAllTransmissions() {
        TransmissionXML transmission = new TransmissionXML();
        this.store.addTransmission(transmission);
        assertTrue(this.store.getAllTransmissions().contains(transmission));
    }

    @Test
    public void whenAddUser() {
        User user = new User();
        this.store.addUser(user);
        assertTrue(this.store.getUsers().contains(user));
    }

    @Test
    public void whenGetAllUsers() {
        User user = new User();
        this.store.addUser(user);
        assertTrue(this.store.getUsers().contains(user));
    }

    @Test
    public void whenGetUserByLogin() {
        User user = new User();
        user.setLogin("User001");
        this.store.addUser(user);
       assertThat(this.store.getUserByLogin("User001"), is(user));
    }

    @Test
    public void whenGetUserById() {
        User user = new User();
        this.store.addUser(user);
        assertThat(this.store.getUserById(user.getId()), is(user));
    }

    @Test
    public void whenGetCarsWithImage() {
        CarXML car001 = new CarXML();
        car001.setImageBase64("test");
        CarXML car002 = new CarXML();
        car002.setImageBase64("");
        this.store.addCar(car001);
        this.store.addCar(car002);
        assertTrue(this.store.getCarWithImage().contains(car001));
        assertFalse(this.store.getCarWithImage().contains(car002));
    }

    @Test
    public void whenGetCarsWithBrand() {
        CarXML car001 = new CarXML();
        Brand brand001 = new Brand();
        this.store.addBrand(brand001);
        car001.setBrand(brand001);
        CarXML car002 = new CarXML();
        Brand brand002 = new Brand();
        this.store.addBrand(brand002);
        car002.setBrand(brand002);
        this.store.addCar(car001);
        this.store.addCar(car002);
        assertTrue(this.store.getCarWithBrand(brand001.getId()).contains(car001));
        assertFalse(this.store.getCarWithBrand(brand001.getId()).contains(car002));
    }

    @Test
    public void whenGetCarsWithLastDay() {
        CarXML car001 = new CarXML();
        long now = new Timestamp(System.currentTimeMillis()).getTime();
        car001.setDate(now);
        this.store.addCar(car001);
        assertTrue(this.store.getCarLastDay().contains(car001));
    }

    @Test
    public void whenGetLastDay() {
        long now = new Timestamp(System.currentTimeMillis()).getTime();
        long lastDay = now - 86400000;
        assertThat(this.store.getLastDay(now), is(lastDay));
    }

}