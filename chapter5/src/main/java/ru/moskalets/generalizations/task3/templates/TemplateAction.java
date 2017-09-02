package ru.moskalets.generalizations.task3.templates;

/**
 * This abstract class.
 */
public abstract class TemplateAction {
	/**
	 * start().
	 */
	abstract void start();
	/**
	 * finish().
	 */
	abstract void finish();
	/**
	 * work().
	 */
	public void work() {
		this.start();
		this.finish();
	}
}