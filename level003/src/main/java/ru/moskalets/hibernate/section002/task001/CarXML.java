package ru.moskalets.hibernate.section002.task001;

public class CarXML extends Car {
    private int id;
    private CarbodyXML carbody;
    private MotorXML motor;
    private TransmissionXML transmission;
    public CarXML() {
    }
    public CarXML(int id) {
        this.id = id;
    }
    public CarXML(int id, CarbodyXML carbody, MotorXML motor, TransmissionXML transmission) {
        this.id = id;
        this.carbody = carbody;
        this.motor = motor;
        this.transmission = transmission;
    }
    public CarXML(CarbodyXML carbody, MotorXML motor, TransmissionXML transmission) {
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
}