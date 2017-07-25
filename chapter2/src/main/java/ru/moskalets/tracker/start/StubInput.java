package ru.moskalets.tracker.start;

public class StubInput implements Input {
	private String[] answers;
	private int position = 0;
	
	public StubInput(String[] answers){
		this.answers = answers;
	}
	public String ask(String question){
		return answers[position++];
	}
	
	public int ask(String question, int[] range){
		//throw new UnsupportedOperationException("Unsupprted operation");
		return -1;
	}
}