package ru.moskalets.chapter003.jdbc.task002;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Класс конвертирует файл xml в другой файл xml через XSLT.
 */
public class ConvertXSQT {
    /**
     * fileNameSource.
     */
    private String fileNameSource = "level002\\src\\main\\java\\ru\\moskalets\\chapter003\\jdbc\\task002\\entries.xml";
    /**
     * fileNameDestance.
     */
    private String fileNameDestance = "level002\\src\\main\\java\\ru\\moskalets\\chapter003\\jdbc\\task002\\entries002.xml";
    /**
     * fileNameScheme.
     */
    private String fileNameScheme = "level002\\src\\main\\java\\ru\\moskalets\\chapter003\\jdbc\\task002\\scheme.xsl";

    /**
     * Преобразует файлы.
     */
    public void convert() {
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            Source scheme = new StreamSource(new FileInputStream(this.fileNameScheme));
            Transformer transformer = factory.newTransformer(scheme);
            Source source = new StreamSource(new FileInputStream(this.fileNameSource));
            transformer.transform(source, new StreamResult(new FileOutputStream(this.fileNameDestance)));
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }
    }
}