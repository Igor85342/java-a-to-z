package ru.moskalets.chapter003.jdbc.task001.start;
import java.util.Scanner;
/**
 * Class ConsoleInput implements Input.
 * @author Igor Moskalets.
 */
public class ConsoleInput implements Input {
	/**
	 * scanner.
	 */
	private Scanner scanner = new Scanner(System.in);
	/**
	 * ask().
	 * @param question .
	 * @return String.
	 */
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
	/**
	 * ask().
	 * @param question .
	 * @param range .
	 * @return int.
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range.");
		}
	}
}