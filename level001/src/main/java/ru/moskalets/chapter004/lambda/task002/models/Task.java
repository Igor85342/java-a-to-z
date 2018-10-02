package ru.moskalets.chapter004.lambda.task002.models;
/**
 * The class implements the task object.
 */
public class Task extends Item {
	/**
	 * Constructor.
	 * @param name .
	 * @param desc .
	 */
	public Task(String name, String desc) {
		super();
		//this.name = name;
		//this.description = desc;
	}

	/**
	 * calculatePrice().
	 * @return String.
	 */
	public String calculatePrice() {
		return "100";
	}
}