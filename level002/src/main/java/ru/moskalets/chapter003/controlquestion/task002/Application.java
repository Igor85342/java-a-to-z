package ru.moskalets.chapter003.controlquestion.task002;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Основной класс приложения.
 */
public class Application implements Job {
    /**
     * url
     */
    private String url;
    /**
     * username
     */
    private String username;
    /**
     * password
     */
    private String password;
    /**
     * time
     */
    private String time;
    public static void main(String[] args) throws Exception {
        Application app = new Application();
        app.getProperties();
        Trigger trigger = new Trigger(app.time);
        trigger.triggerStart();
    }

    /**
     * Метод запускает парсинг страниц и запись в бд.
     * @throws IOException
     * @throws SQLException
     */
    public void applicationRun() throws IOException, SQLException {
        Parser p = new Parser();
        p.getCurrentYear();
        p.parsingPosts();
        try (StoreSQL storeSQL = new StoreSQL(this.url, this.username, this.password)) {
            storeSQL.createTable();
            storeSQL.addPosts(p.getPosts());
        }
    }

    @Override
    public void execute(JobExecutionContext context)   {
     try {
         applicationRun();
     } catch (IOException | SQLException e) {
         e.printStackTrace();
     }
    }

    /**
     * Метод читает настройки из файла app.proerties.
     */
    public void getProperties() {
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("level002\\src\\main\\java\\ru\\moskalets\\chapter003\\controlquestion\\task002\\app.properties")) {
            prop.load(fileInputStream);
            this.url = prop.getProperty("jdbc.url");
            this.username = prop.getProperty("jdbc.username");
            this.password = prop.getProperty("jdbc.password");
            this.time = prop.getProperty("cron.time");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}