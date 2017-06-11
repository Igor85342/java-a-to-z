package ru.moskalets.generalizations.task3.start;
public interface UserAction {
	int key();
	void execute(Input input, Tracker tracker);
	String info();
}