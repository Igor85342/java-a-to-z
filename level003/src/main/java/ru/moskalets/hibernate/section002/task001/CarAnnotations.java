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
}