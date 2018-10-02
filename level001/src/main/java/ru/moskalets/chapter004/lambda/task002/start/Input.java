package ru.moskalets.chapter004.lambda.task002.start;

/**
 * Interface Input.
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