package ru.moskalets.generalizations.task3.start;

/**
 * Interface Input.
 * @author Igor Moskalets.
 * @since 02.09.2017.
 */
public interface Input {
	/**
	 * ask().
	 * @param question .
	 * @return String.
	 */
	String ask(String question);

	/**
	 * ask().
	 * @param question .
	 * @param range .
	 * @return int.
	 */
	int ask(String question, int[] range);
}