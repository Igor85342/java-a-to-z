package ru.moskalets.chapter003.controlquestion.task002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;

/**
 * Класс для работы с бд.
 */
public class StoreSQL implements AutoCloseable {
    /**
     * log
     */
    private static Logger log = LoggerFactory.getLogger(StoreSQL.class);
    /**
     * conn
     */
    private Connection conn;

    /**
     * Консруктор
     * @param url
     * @param username
     * @param password
     * @throws SQLException
     */
    public StoreSQL(String url, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, username, password);
    }

    /**
     * Метод создает таблицу.
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        try (Statement statement = this.conn.createStatement()) {
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS posts"
                            + "(id serial primary key not null,"
                            + "name varchar(2000),"
                            + "url varchar(2000),"
                            + "UNIQUE(name, url));"
            );
        }
    }

    /**
     * Метод добавляет пост, если его имя или ссылка уникальные.
     * @param posts
     * @throws SQLException
     */
    public void addPosts(ArrayList<Post> posts) throws SQLException {
        for (Post post : posts) {
            try (PreparedStatement st = conn.prepareStatement("insert into posts(name, url) values(?, ?)")) {
                st.setString(1, post.getName());
                st.setString(2, post.getUrl());
                st.executeUpdate();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
    @Override
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }
}