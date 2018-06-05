package ru.moskalets.chapter003.jdbc.task001.templates;

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