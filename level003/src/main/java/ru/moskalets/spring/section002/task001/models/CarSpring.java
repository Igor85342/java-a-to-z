package ru.moskalets.spring.section002.task001.models;
import javax.persistence.*;

@Entity
@Table(name = "Cars")
public class CarSpring {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategorySpring category;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private BrandSpring brand;

    @ManyToOne
    @JoinColumn(name = "id_carbody")
    private CarbodySpring carbody;

    @ManyToOne
    @JoinColumn(name = "id_motor")
    private MotorSpring motor;

    @ManyToOne
    @JoinColumn(name = "id_transmission")
    private TransmissionSpring transmission;

    @Column(name = "image_base64")
    private String imageBase64;

    private boolean sold;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserSpring user;

    private long date;

    public CarSpring() {
    }

    public CarSpring(CategorySpring category, BrandSpring brand, CarbodySpring carbody, MotorSpring motor, TransmissionSpring transmission, String imageBase64, boolean sold, UserSpring user, long date) {
        this.category = category;
        this.brand = brand;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
        this.imageBase64 = imageBase64;
        this.sold = sold;
        this.user = user;
        this.date = date;
    }

    public CarSpring(int id, CategorySpring category, BrandSpring brand, CarbodySpring carbody, MotorSpring motor, TransmissionSpring transmission, String imageBase64, boolean sold, UserSpring user, long date) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
        this.imageBase64 = imageBase64;
        this.sold = sold;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategorySpring getCategory() {
        return this.category;
    }

    public void setCategory(CategorySpring category) {
        this.category = category;
    }

    public BrandSpring getBrand() {
        return this.brand;
    }

    public void setBrand(BrandSpring brand) {
        this.brand = brand;
    }

    public CarbodySpring getCarbody() {
        return this.carbody;
    }

    public void setCarbody(CarbodySpring carbody) {
        this.carbody = carbody;
    }

    public MotorSpring getMotor() {
        return this.motor;
    }

    public void setMotor(MotorSpring motor) {
        this.motor = motor;
    }

    public TransmissionSpring getTransmission() {
        return this.transmission;
    }

    public void setTransmission(TransmissionSpring transmission) {
        this.transmission = transmission;
    }

    public String getImageBase64() {
        return this.imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public boolean isSold() {
        return this.sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public UserSpring getUser() {
        return this.user;
    }

    public void setUser(UserSpring user) {
        this.user = user;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarSpring carSpring = (CarSpring) o;
        return id == carSpring.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}