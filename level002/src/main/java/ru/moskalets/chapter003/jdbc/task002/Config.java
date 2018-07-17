package ru.moskalets.chapter003.jdbc.task002;

import java.sql.*;

/**
 * Класс содержит настройки подключения к базе данных.
 */
public class Config {
    /**
     * conn.
     */
    private Connection conn = null;

    /**
     * Установка соединения с бд.
     */
    public void startDB() {
        try {
            Class.forName("org.sqlite.JDBC");
//            conn = DriverManager.getConnection("jdbc:sqlite:task002.s3db");
            conn = DriverManager.getConnection("jdbc:sqlite:level002\\src\\main\\java\\ru\\moskalets\\chapter003\\jdbc\\task002\\task002.s3db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает conn.
     * @return
     */
    public Connection getConn() {
        return this.conn;
    }
}