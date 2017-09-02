package ru.moskalets.generalizations.task3.start;

/**
 * Class ValidateInput.
 * @author Igor Moskalets
 * @since 02.09.2017
 */
public class ValidateInput extends ConsoleInput {
	/**
	 * ask().
	 * @param question .
	 * @param range .
	 * @return int.
	 */
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try  {
				value = super.ask(question, range);
				invalid = false;
			} catch (MenuOutException moe) {
				System.out.println("Please select key for menu.");
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter validate data again.");
			}
		} while (invalid);
		return value;
	}
}