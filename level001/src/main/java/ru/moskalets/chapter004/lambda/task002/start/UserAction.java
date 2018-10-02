package ru.moskalets.chapter004.lambda.task002.start;

/**
 * Interface UserAction.
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
	void execute(Input input, Tracker tracker);

	/**
	 * info().
	 * @return String.
	 */
	String info();
}