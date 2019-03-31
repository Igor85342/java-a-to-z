package ru.moskalets.hibernate.section002.task001;

public class CarXML extends Car {
    private int id;
    private Category category;
    private Brand brand;
    private CarbodyXML carbody;
    private MotorXML motor;
    private TransmissionXML transmission;
    private String imageBase64;
    private boolean sold;
    private User user;

    public CarXML() {
    }
    public CarXML(int id) {
        this.id = id;
    }
    public CarXML(int id, Category category, Brand brand, CarbodyXML carbody, MotorXML motor, TransmissionXML transmission, String imageBase64, boolean sold, User user) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
        this.imageBase64 = imageBase64;
        this.sold = sold;
        this.user = user;
    }
    public CarXML(Category category, Brand brand, CarbodyXML carbody, MotorXML motor, TransmissionXML transmission, String imageBase64, boolean sold, User user) {
        this.category = category;
        this.brand = brand;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
        this.imageBase64 = imageBase64;
        this.sold = sold;
        this.user = user;
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
    public String getImageBase64() {
        return this.imageBase64;
    }
    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
    public boolean getSold() {
        return this.sold;
    }
    public void setSold(boolean sold) {
        this.sold = sold;
    }
    public User getUser() {
        return this.user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarXML carXML = (CarXML) o;

        if (id != carXML.id) {
            return false;
        }
        if (sold != carXML.sold) {
            return false;
        }
        if (category != null ? !category.equals(carXML.category) : carXML.category != null) {
            return false;
        }
        if (brand != null ? !brand.equals(carXML.brand) : carXML.brand != null) {
            return false;
        }
        if (carbody != null ? !carbody.equals(carXML.carbody) : carXML.carbody != null) {
            return false;
        }
        if (motor != null ? !motor.equals(carXML.motor) : carXML.motor != null) {
            return false;
        }
        if (transmission != null ? !transmission.equals(carXML.transmission) : carXML.transmission != null) {
            return false;
        }
        if (imageBase64 != null ? !imageBase64.equals(carXML.imageBase64) : carXML.imageBase64 != null) {
            return false;
        }
        return user != null ? user.equals(carXML.user) : carXML.user == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (carbody != null ? carbody.hashCode() : 0);
        result = 31 * result + (motor != null ? motor.hashCode() : 0);
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        result = 31 * result + (imageBase64 != null ? imageBase64.hashCode() : 0);
        result = 31 * result + (sold ? 1 : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}