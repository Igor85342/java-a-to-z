package ru.moskalets.chapter003.jdbc.task001.start;

/**
 * Class StubInput.
 * @author Igor Moskalets.
 */
public class StubInput implements Input {
	/**
	 * answers.
	 */
	private String[] answers;
	/**
	 * position.
	 */
	private int position = 0;

	/**
	 * StubInput.
	 * @param answers .
	 */
	public StubInput(String[] answers) {
		this.answers = answers;
	}

	/**
	 * ask().
	 * @param question .
	 * @return String.
	 */
	public String ask(String question) {
		return answers[position++];
	}

	/**
	 * ask().
	 * @param question .
	 * @param range .
	 * @return int.
	 */
	public int ask(String question, int[] range) {
		return -1;
	}
}