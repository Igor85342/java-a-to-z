package ru.moskalets.generalizations.task3.models;
/**
 * The class implements the task object.
 * author Igor Moskalets.
 * Since 09.06.2017.
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