package ru.moskalets.chapter003.jdbc.task001.start;

import java.sql.SQLException;

/**
 * Interface UserAction.
 * @author Igor Moskalets.
 * @since 02.09.2017.
 */
public interface UserAction {
	/**
	 * key().
	 * @return int.
	 */
	int key();

	/**
	 * execute().
	 * @param input .
	 * @param tracker .
	 */
	void execute(Input input, Tracker tracker) throws SQLException;

	/**
	 * info().
	 * @return String.
	 */
	String info();
}