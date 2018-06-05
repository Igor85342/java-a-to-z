package ru.moskalets.chapter003.jdbc.task001.models;
/**
 * The class implements the task object.
 * author Igor Moskalets.
 */
public class Task extends Item {
	/**
	 * Constructor.
	 * @param name .
	 * @param desc .
	 */
	public Task(String name, String desc) {
		super();
	}
	/**
	 * calculatePrice().
	 * @return String.
	 */
	public String calculatePrice() {
		return "100";
	}
}