package ru.moskalets.chapter003.jdbc.task002;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс генерирует xml файл.
 */
public class StoreXML {
    /**
     * fileName.
     */
    String fileName = "level002\\src\\main\\java\\ru\\moskalets\\chapter003\\jdbc\\task002\\entries.xml";
    /**
     * entries.
     */
    Entries entries;

    /**
     * Конструктор.
     * @param entries
     */
    public StoreXML(Entries entries) {
        this.entries = entries;
    }

    /**
     * Сохраняет данные в файл из класс Entries.
     */
    public void save() {
        System.out.println("Marker");
        try (FileOutputStream file = new FileOutputStream(new File(this.fileName).getAbsolutePath().toString())) {
            JAXBContext context = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this.entries, file);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}