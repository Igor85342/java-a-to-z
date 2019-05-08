package ru.moskalets.spring.section001.task001;

import org.slf4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStorage implements Storage, AutoCloseable {
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(JdbcStorage.class);
    private Connection conn;

    public JdbcStorage(Configuration config) throws SQLException {
        this.conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
    }

    public void add(User user) {
        try (PreparedStatement st = conn.prepareStatement("insert into users(name) values (?)")) {
            st.setString(1, user.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public List<User> getAll() {
        ArrayList<User> result = new ArrayList<User>();
        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM users")) {
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    result.add(new User(rs.getInt("id"), rs.getString("name")));
                }
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}