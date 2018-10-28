package ru.moskalets.chapter004.httpprotocol;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
             PreparedStatement st = connection.prepareStatement("insert into users(login, password, role, createdate) values(?, ?, ?, ?)")) {
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getRole());
            st.setString(4, user.getCreateDate().toString());
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("update users as u set login = ?, password = ?, role = ? where u.id = ?")) {
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getRole());
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
                    result.put(rs.getInt("id"), new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"), rs.getString("createdate")));
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("select * from users where id = ?")) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                rs.next();
                user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"), rs.getString("createdate"));
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return user;
    }

    public User isCredentional(String login, String password) {
        User user = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("select * from users where login = ? and password = ?")) {
            st.setString(1, login);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"), rs.getString("createdate"));
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return user;
    }

    public List<Role> getAllRoles() {
        List<Role> result = new ArrayList<Role>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            try (ResultSet rs = st.executeQuery("select * from roles")) {
                while (rs.next()) {
                    result.add(new Role(rs.getInt("id"), rs.getString("name")));
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }
}