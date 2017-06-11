package ru.moskalets.generalizations.task3.models;
/**
 * The class implements the task object
 * author Igor Moskalets
 * Since 09.06.2017
 */
public class Task extends Item {
	public Task(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
	public String calculatePrice() {
		return "100";
	}
}