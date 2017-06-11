package ru.moskalets.generalizations.task3.start;
import ru.moskalets.generalizations.task3.models.*;
import java.util.ArrayList;
/**
 * The class is responsible for menu changes.
 * author Igor Moskalets
 * Since 10.06.2017
 */
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
/**
 * The main class menu tracker.
 * author Igor Moskalets
 * Since 10.06.2017
 */
public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private ArrayList<UserAction> actions = new ArrayList();
	private int position = 0;
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	public void fillActions() {
		this.actions.add(new AddItem("Add the new item."));
		this.actions.add(new ShowItems("Show all items"));
		this.actions.add(new EditItem("Edit item."));
		this.actions.add(new FindItemByName("Find item by name."));
		this.actions.add(new FindItemByDesc("Find item by desc."));
		this.actions.add(new DeleteItem("Delete the item."));
		this.actions.add(new AddCommentToItem("Add comment to the Item."));
		this.actions.add(new ShowAllCommentsToItem("Show comments to the Item."));
	}
	public void addAction(UserAction action) {
		this.actions.add(action);
	}
	public void select(int key) {
		this.actions.get(key).execute(this.input, this.tracker);
	}
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
	/**
	 * Adds a item to the tracker.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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
	/**
	 * Shows all items in the tracker.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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
	/**
	 * Looking for the item name.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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
	/**
	 * Looking for the item description.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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
	/**
	 * Delete a item to the tracker.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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
	/**
	 * Adds a comment to the selected item.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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
				tracker.addComment(name,comment);
			}
		}
	}
	/**
	 * Shows all comments from the selected item.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
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