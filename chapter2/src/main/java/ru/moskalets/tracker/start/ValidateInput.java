package ru.moskalets.tracker.start;

public class ValidateInput extends ConsoleInput {
	public int ask(String question, int[] range) {
		boolean invalid = true;
		int value = -1;
		do {
			try  {
				value = super.ask(question, range);
				invalid = false;
			} catch(MenuOutException moe) {
				System.out.println("Please select key for menu.");
			} catch(NumberFormatException nfe) {
				System.out.println("Please enter validate data again.");
			}
		} while (invalid);
		return value;
	}
	
	
}