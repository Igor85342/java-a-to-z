package ru.moskalets.hibernate.section002.task001;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DbStoreTest {
//    @Test
    public void whenAddCarXML() {
       try (DbStore dbStore = new DbStore()) {
           dbStore.deleteTableCar();
//           dbStore.addCar(new CarXML(new Category(1), new Brand(1), new CarbodyXML(1), new MotorXML(1), new TransmissionXML(1)));
           assertThat(dbStore.getCarXML(1).getCarbody().getName(), is("Carbody001"));
           assertThat(dbStore.getCarXML(1).getMotor().getName(), is("motor001"));
           assertThat(dbStore.getCarXML(1).getTransmission().getName(), is("Transmission001"));
    }

    }
//    @Test
    public void whenAddCarAnnotations() {
        try (DbStore dbStore = new DbStore()) {
            dbStore.deleteTableCar();
            dbStore.addCar(new CarAnnotations(new CarbodyAnnotations(1), new MotorAnnotations(1), new TransmissionAnnotations(1)));
            assertThat(dbStore.getCarXML(1).getCarbody().getName(), is("Carbody001"));
            assertThat(dbStore.getCarXML(1).getMotor().getName(), is("motor001"));
            assertThat(dbStore.getCarXML(1).getTransmission().getName(), is("Transmission001"));
        }
    }
//    @Test
    public void whenUpdateCarXML() {
        try (DbStore dbStore = new DbStore()) {
            dbStore.deleteTableCar();
//            dbStore.addCar(new CarXML(new CarbodyXML(1), new MotorXML(1), new TransmissionXML(1)));
//            dbStore.updateCar(new CarXML(1, new CarbodyXML(2), new MotorXML(2), new TransmissionXML(2)));
            assertThat(dbStore.getCarXML(1).getCarbody().getName(), is("Carbody002"));
            assertThat(dbStore.getCarXML(1).getMotor().getName(), is("Motor002"));
            assertThat(dbStore.getCarXML(1).getTransmission().getName(), is("Transmission002"));
        }
    }
//    @Test
    public void whenUpdateCarAnnotations() {
        try (DbStore dbStore = new DbStore()) {
            dbStore.deleteTableCar();
            dbStore.addCar(new CarAnnotations(new CarbodyAnnotations(1), new MotorAnnotations(1), new TransmissionAnnotations(1)));
            dbStore.updateCar(new CarAnnotations(1, new CarbodyAnnotations(2), new MotorAnnotations(2), new TransmissionAnnotations(2)));
            assertThat(dbStore.getCarXML(1).getCarbody().getName(), is("Carbody002"));
            assertThat(dbStore.getCarXML(1).getMotor().getName(), is("Motor002"));
            assertThat(dbStore.getCarXML(1).getTransmission().getName(), is("Transmission002"));
        }
    }
//    @Test
    public void whenDeleteCarXML() {
        try (DbStore dbStore = new DbStore()) {
            dbStore.deleteTableCar();
//            dbStore.addCar(new CarXML(new CarbodyXML(1), new MotorXML(1), new TransmissionXML(1)));
            dbStore.deleteCar(new CarXML(1));
            assertThat(dbStore.getAllCarsXML().size(), is(0));
        }
    }
//    @Test
    public void whenDeleteCarAnnotations() {
        try (DbStore dbStore = new DbStore()) {
            dbStore.deleteTableCar();
            dbStore.addCar(new CarAnnotations(new CarbodyAnnotations(1), new MotorAnnotations(1), new TransmissionAnnotations(1)));
            dbStore.deleteCar(new CarAnnotations(1));
            assertThat(dbStore.getAllCarsAnnotations().size(), is(0));
        }
    }
}