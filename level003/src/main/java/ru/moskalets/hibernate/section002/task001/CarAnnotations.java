package ru.moskalets.hibernate.section002.task001;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarAnnotations extends Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_carbody")
    private CarbodyAnnotations carbody;
    @ManyToOne
    @JoinColumn(name = "id_motor")
    private MotorAnnotations motor;
    @ManyToOne
    @JoinColumn(name = "id_transmission")
    private TransmissionAnnotations transmission;
    public CarAnnotations() {
    }
    public CarAnnotations(int id) {
        this.id = id;
    }
    public CarAnnotations(int id, CarbodyAnnotations carbody, MotorAnnotations motor, TransmissionAnnotations transmission) {
        this.id = id;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
    }
    public CarAnnotations(CarbodyAnnotations carbody, MotorAnnotations motor, TransmissionAnnotations transmission) {
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public CarbodyAnnotations getCarbody() {
        return this.carbody;
    }
    public void setCarbody(CarbodyAnnotations carbody) {
        this.carbody = carbody;
    }
    public MotorAnnotations getMotor() {
        return this.motor;
    }
    public void setMotor(MotorAnnotations motor) {
        this.motor = motor;
    }
    public TransmissionAnnotations getTransmission() {
        return this.transmission;
    }
    public void setTransmission(TransmissionAnnotations transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarAnnotations that = (CarAnnotations) o;

        if (id != that.id) return false;
        if (carbody != null ? !carbody.equals(that.carbody) : that.carbody != null) return false;
        if (motor != null ? !motor.equals(that.motor) : that.motor != null) return false;
        return transmission != null ? transmission.equals(that.transmission) : that.transmission == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carbody != null ? carbody.hashCode() : 0);
        result = 31 * result + (motor != null ? motor.hashCode() : 0);
        result = 31 * result + (transmission != null ? transmission.hashCode() : 0);
        return result;
    }
}