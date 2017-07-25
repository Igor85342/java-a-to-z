package ru.moskalets.tracker.start;

import ru.moskalets.tracker.models.*;

class EditItem extends BaseAction{
	
	public EditItem (String name){
			super(name);
		}
		
	public int key() {
			return 2;
		}
		
		public void execute(Input input, Tracker tracker) {
			String nameItemEdit = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(nameItemEdit);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				String name = input.ask("Please, enter the task's new name: ");
				String desc = input.ask("Please, enter the task's new desc: ");
				Item itemEdit = tracker.edit(name,desc,itemFind.getId());
				tracker.update(itemEdit);
			}
			
		}
		
}

public class MenuTracker {
	
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[10];
	private int position = 0;
	
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		this.actions[position++] = new AddItem("Add the new item.");
		this.actions[position++] = new MenuTracker.ShowItems("Show all items");
		this.actions[position++] = new EditItem("Edit item.");
		this.actions[position++] = new FindItemByName("Find item by name.");
		this.actions[position++] = new FindItemByDesc("Find item by desc.");
		this.actions[position++] = new DeleteItem("Delete the item.");
		this.actions[position++] = new AddCommentToItem("Add comment to the Item.");
		this.actions[position++] = new ShowAllCommentsToItem("Show comments to the Item.");

	}
	
	public void addAction(UserAction action) {
		this.actions[position++] = action;
	}
	
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}
	
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
	
	private class AddItem extends BaseAction {
		
		public AddItem (String name){
			super(name);
		}
		
		public int key() {
			return 0;
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			String desc = input.ask("Please, enter the task's desc: ");
			tracker.add(new Task(name,desc));
			
		}
		
	}
	
	private static class ShowItems extends BaseAction {
		
		public ShowItems (String name){
			super(name);
		}
		public int key() {
			return 1;
		}
		
		public void execute(Input input, Tracker tracker) {
			for (Item item : tracker.getAll()) {
				 if (item != null) System.out.println(String.format("%s. %s", item.getId(), item.getName()));
			}
			
		}
		
	}
	
	private class FindItemByName extends BaseAction {
		
		public FindItemByName (String name){
			super(name);
		}
		
		public int key() {
			return 3;
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(name);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				System.out.println(String.format("%s", itemFind.getName() ));
			}
		}
		
	}
	
	private class FindItemByDesc extends BaseAction {
		
		public FindItemByDesc (String name){
			super(name);
		}
		
		public int key() {
			return 4;
		}
		
		public void execute(Input input, Tracker tracker) {
			String desc = input.ask("Please, enter the task's desc: ");
			Item itemFind = tracker.findByDesc(desc);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				System.out.println(String.format("%s",itemFind.getName() ));
			}
			
		}
		
	}
	
	private class DeleteItem extends BaseAction {
		
		public DeleteItem (String name){
			super(name);
		}
		
		public int key() {
			return 5;
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(name);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				tracker.remove(itemFind);
			}
					
		}
		
	}
	
	private class AddCommentToItem extends BaseAction {
		
		public AddCommentToItem (String name){
			super(name);
		}
		
		public int key() {
			return 6;
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(name);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				String comment = input.ask("Please, enter the comment; ");
				tracker.addcomment(name,comment);
			}
			
		}
		
	}
	
	private class ShowAllCommentsToItem extends BaseAction {
		
		public ShowAllCommentsToItem (String name){
			super(name);
		}
		
		public int key() {
			return 7;
		}
		
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(name);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				for (String comment : itemFind.getComments()) {
					System.out.println(String.format("%s", comment));
				}
			}	
			
		}
		
	}
} 