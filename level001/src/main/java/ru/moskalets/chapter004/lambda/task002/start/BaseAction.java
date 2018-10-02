package ru.moskalets.chapter004.lambda.task002.start;

/**
 * Abstract class BaseAction implements UserAction.
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