package ru.moskalets.hibernate.section002.task001;

import java.sql.Blob;

public class CarXML extends Car {
    private int id;
    private Category category;
    private Brand brand;
    private CarbodyXML carbody;
    private MotorXML motor;
    private TransmissionXML transmission;
    private Blob photo;
//    private byte[] photo;
    public CarXML() {
    }
    public CarXML(int id) {
        this.id = id;
    }
    public CarXML(int id, Category category, Brand brand, CarbodyXML carbody, MotorXML motor, TransmissionXML transmission, Blob photo) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
        this.photo = photo;
    }
    public CarXML(Category category, Brand brand, CarbodyXML carbody, MotorXML motor, TransmissionXML transmission, Blob photo) {
        this.category = category;
        this.brand = brand;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
        this.photo = photo;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Category getCategory() {
        return this.category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Brand getBrand() {
        return this.brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public CarbodyXML getCarbody() {
        return this.carbody;
    }
    public void setCarbody(CarbodyXML carbody) {
        this.carbody = carbody;
    }
    public MotorXML getMotor() {
        return this.motor;
    }
    public void setMotor(MotorXML motor) {
        this.motor = motor;
    }
    public TransmissionXML getTransmission() {
        return this.transmission;
    }
    public void setTransmission(TransmissionXML transmission) {
        this.transmission = transmission;
    }
    public Blob getPhoto() {
        return this.photo;
    }
    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarXML carXML = (CarXML) o;

        if (id != carXML.id) return false;
        if (category != null ? !category.equals(carXML.category) : carXML.category != null) return false;
        if (brand != null ? !brand.equals(carXML.brand) : carXML.brand != null) return false;
        if (carbody != null ? !carbody.equals(carXML.carbody) : carXML.carbody != null) return false;
        if (motor != null ? !motor.equals(carXML.motor) : carXML.motor != null) return false;
        if (transmission != null ? !transmission.equals(carXML.transmission) : carXML.transmission != null)
            return false;
        return photo != null ? photo.equals(carXML.photo) : carXML.photo == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (carbody != null ? carbody.hashCode() : 0);
        result = 31 * result + (motor != null ? motor.hashCode() : 0);
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }
}