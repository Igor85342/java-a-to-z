package ru.moskalets.chapter003.jdbc.task002;

import java.sql.*;

/**
 * Класс создает таблицу, генерирует данные, записывает их в класс Entries.
 */
public class StoreSQL implements AutoCloseable {
    /**
     * config
     */
    private Config config;

    /**
     * Конструктор.
     * @param config
     */
    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * В методе создается таблица.
     */
    public void createTable() {
        try (PreparedStatement ps = config.getConn().prepareStatement("create table if not exists 'entry' ('id' integer primary key autoincrement, 'field' text)")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Table create!");
    }

    /**
     * В методе генерируются данные.
     * @param count
     */
    public void generate(int count) {
        try  {
            config.getConn().setAutoCommit(false);
            PreparedStatement ps = config.getConn().prepareStatement("insert into 'entry' ('field') values (?)");
            for (int i = 1; i < count + 1; i++) {
                ps.setInt(1, i);
                ps.executeUpdate();
            }
            config.getConn().commit();
            config.getConn().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                config.getConn().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * В методе считываются данные и записываются в класс Entries.
     * @return
     */
    public Entries read() {
        Entries result = new Entries();
        try (
                PreparedStatement ps = config.getConn().prepareStatement("select * from entry");
                ResultSet rs = ps.executeQuery();
                ) {
            while (rs.next()) {
                result.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * В методе удаляется таблица.
     */
    public void delete() {
        try (PreparedStatement ps = config.getConn().prepareStatement("drop table if exists entry;")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            config.getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
