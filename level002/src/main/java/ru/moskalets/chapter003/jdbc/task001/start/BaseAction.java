package ru.moskalets.chapter003.jdbc.task001.start;

import java.sql.SQLException;

/**
 * Abstract class BaseAction implements UserAction.
 * @author Igor Moskalets.
 */
public abstract class BaseAction implements UserAction {
	/**
	 * name.
	 */
	private String name;

	/**
	 * BaseAction.
	 * @param name .
	 */
	public BaseAction(String name) {
		this.name = name;
	}

	/**
	 * key().
	 * @return int.
	 */
	public abstract int key();

	/**
	 * execute().
	 * @param input .
	 * @param tracker .
	 */
	public abstract void execute(Input input, Tracker tracker) throws SQLException;

	/**
	 * info().
	 * @return String.
	 */
	public String info() {
			return String.format("%s. %s", this.key(), this.name);
		}
}