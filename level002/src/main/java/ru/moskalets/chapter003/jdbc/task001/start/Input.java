package ru.moskalets.chapter003.jdbc.task001.start;

/**
 * Interface Input.
 * @author Igor Moskalets.
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