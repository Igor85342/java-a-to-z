package ru.moskalets.generalizations.task3.templates;

public abstract class TemplateAction {
	abstract void start();
	
	abstract void finish();
	
	public void work() {
		this.start();
		this.finish();
	}
}