package ru.moskalets.tracker.start;

import ru.moskalets.tracker.models.*;


public class StartUI {
	private int[] ranges = new int[] {0,1,2,3,4,5,6,7};
	private Input input;
	
	public StartUI(Input input){
		this.input = input;
	}
	
	public void init() {
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.input,tracker);
		menu.fillActions();
		UserAction deleteAction = new UserAction(){
			public int key() {
				return 8;
			}
	
			public void execute(Input input, Tracker tracker) {
				//todo
			}
	
			public String info() {
				return "8. Delete";
			}
		};
		menu.addAction(deleteAction);
		do {
			menu.show();
			menu.select(input.ask("select:", ranges));
		} while(!"y".equals(this.input.ask("Exit?(y)")));
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Input input = new ValidateInput();
		new StartUI(input).init();
		
		
	}
}