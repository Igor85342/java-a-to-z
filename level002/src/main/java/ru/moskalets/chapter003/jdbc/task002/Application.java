package ru.moskalets.chapter003.jdbc.task002;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Класс:
 * 1. Генерирует данные в базе данных;
 * 2. Генерирует данные из бд в xml файл;
 * 3. Преобразует файл xml в другой файл xml через XSLT;
 * 4. Парсит полученный файл и выводит сумму значений всех атрибутов field.
 */
public class Application  {
    /**
     * fileNameDestance
     */
   private String fileNameDestance = "C:\\projects\\java-a-to-z\\level002\\src\\main\\java\\ru\\moskalets\\chapter003\\jdbc\\task002\\entries002.xml";
    /**
     * entries.
     */
   private ArrayList<Entry> entries = new ArrayList<Entry>();
    public static void main(String[] args)  {
        Application application = new Application();
        application.startApplication();
    }

    /**
     * Запуск приложения.
     */
    public void startApplication() {
            Config config = new Config();
            config.startDB();
            StoreSQL ssql = new StoreSQL(config);
            ssql.createTable();
            ssql.generate(1000000);
            ssql.read();
            StoreXML storeXML = new StoreXML(ssql.read());
            storeXML.save();
            ConvertXSQT convertXSQT = new ConvertXSQT();
            convertXSQT.convert();
            parsingFile();
            amount();
            ssql.delete();
            ssql.close();
    }

    /**
     * Парсинг файла.
     */
    public void parsingFile() {
        try {
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equals("entry")) {
                        Entry entry = new Entry(parseInt(attributes.getValue("field")));
                        Application.this.entries.add(entry);
                    }
                }
            };
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(this.fileNameDestance), handler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение суммы.
     * @return
     */
    public int amount() {
        int result = 0;
        for (Entry entry: this.entries) {
            result = result + entry.getField();
        }
        System.out.println(result);
        return result;
    }
}