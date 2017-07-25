package ru.moskalets.tracker.start;

public abstract class BaseAction implements UserAction {
	
	String name;
	
	public BaseAction (String name) {
		this.name = name;
	}
	
	public abstract int key();
	
	public abstract void execute(Input input, Tracker tracker);
	
	public String info() {
			return String.format("%s. %s", this.key(), this.name);
		}
}