package ru.moskalets.chapter003.jdbc.task001.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalets.chapter003.createupdateinsert.task004.SQLStorage;
import ru.moskalets.chapter003.jdbc.task001.models.Item;

import java.sql.*;

/**
 * The main class to operate the tracker. Carries out all operations with items.
 * author Igor Moskalets
 */
public class Tracker {
	/**
	 * log
	 */
	private static Logger log = LoggerFactory.getLogger(SQLStorage.class);
	/**
	 * url
	 */
	private final String url = "jdbc:postgresql://localhost:5432/tracker";
	/**
	 * username
	 */
	private final String username = "postgres";
	/**
	 * password
	 */
	private final String password = "password";
	/**
	 * conn
	 */
	private Connection conn = null;

	/**
	 * Метод создает таблицы.
	 */
	public void createTable() {
		try {
			Statement statement = this.conn.createStatement();
			statement.executeUpdate(
					"CREATE TABLE items "
							+ "(id serial primary key not null,"
							+ "name varchar(2000),"
							+ "description varchar(2000),"
							+ "create_date timestamp);"
					        + "CREATE TABLE comments"
							+ "(id serial primary key not null,"
							+ "text varchar(2000),"
							+ "id_item int not null references items(id))"
			);
			statement.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод добавляет элемент в таблицу items.
	 * @param item
	 */
	public void add(Item item) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("insert into items(name, description, create_date) values(?, ?, ?)");
			st.setString(1, item.getName());
			st.setString(2, item.getDescription());
			st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод удаляет элемент из таблицы items по id.
	 * @param id
	 */
	public void remove(int id) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("delete from items where id = ?");
			st.setInt(1, id);
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод находит элемент в таблице items по id.
	 * @param id
	 */
	public void findById(int id) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("select * from items where id = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			System.out.println(String.format("%d %s %s %s", rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date")));
			rs.close();
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод выводит все элементы из таблицы items.
	 */
	public void getAll() {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from items");
			while (rs.next()) {
				System.out.println(String.format("%d %s %s %s", rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date")));
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод добавляет элемент в таблицу comments.
	 * @param text
	 * @param idItem
	 */
	public void addComment(String text, int idItem) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("insert into comments(text, id_item) values(?, ?)");
			st.setString(1, text);
			st.setInt(2, idItem);
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод находит элемент(ы) по полю name в таблице items.
	 * @param name
	 */
	public void findByName(String name) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("select * from items as i where i.name = ?");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				System.out.println(String.format("%d %s %s %s", rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date")));
			}
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод находит элемент(ы) по полю description в таблице items.
	 * @param description
	 */
	public void findByDesc(String description) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("select * from items as i where i.description = ?");
			st.setString(1, description);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				System.out.println(String.format("%d %s %s %s", rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date")));
			}
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод вносит изменения в элемент таблицы items.
	 * @param id
	 * @param name
	 * @param description
	 */
	public void edit(int id, String name, String description) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("update items as i set name = ?, description = ? where i.id = ?");
			st.setString(1, name);
			st.setString(2, description);
			st.setInt(3, id);
			st.executeUpdate();
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Метод выводит все элементы таблицы comments по связанному с ними элементу из таблиц items.
	 * @param id
	 */
	public void showAllCommentsFromItem(int id) {
		try {
			this.conn = DriverManager.getConnection(url, username, password);
			PreparedStatement st = conn.prepareStatement("select * from comments as c where c.id_item = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				System.out.println(String.format("%d %s %d", rs.getInt("id"), rs.getString("text"), rs.getInt("id_item")));
			}
			st.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}
}