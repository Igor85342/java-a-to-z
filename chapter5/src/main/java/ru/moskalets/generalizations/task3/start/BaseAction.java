package ru.moskalets.generalizations.task3.start;

/**
 * Abstract class BaseAction implements UserAction.
 * @author Igor Moskalets.
 * @since 02.09.2017.
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
	public abstract void execute(Input input, Tracker tracker);

	/**
	 * info().
	 * @return String.
	 */
	public String info() {
			return String.format("%s. %s", this.key(), this.name);
		}
}