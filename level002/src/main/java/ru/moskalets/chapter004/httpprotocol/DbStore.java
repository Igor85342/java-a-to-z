package ru.moskalets.chapter004.httpprotocol;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();
    private static Logger log = LoggerFactory.getLogger(DbStore.class);
    public DbStore() {
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/httpprotocol");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("password");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        SOURCE.setDriverClassName("org.postgresql.Driver");
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }
    @Override
    public void add(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("insert into users(name, login, email, createdate) values(?, ?, ?, ?)")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getCreateDate().toString());
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("update users as u set name = ?, login = ?, email = ? where u.id = ?")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setInt(4, user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = SOURCE.getConnection();
        PreparedStatement st = connection.prepareStatement("delete from users where id = ?")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Map<Integer, User> findAll() {
        Map<Integer, User> result = new HashMap<>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            try (ResultSet rs = st.executeQuery("select * from users")) {
                while (rs.next()) {
                    result.put(rs.getInt("id"), new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), rs.getString("createdate")));
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}