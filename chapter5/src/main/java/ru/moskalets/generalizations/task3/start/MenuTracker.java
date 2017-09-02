package ru.moskalets.generalizations.task3.start;
import ru.moskalets.generalizations.task3.models.Item;
import java.util.ArrayList;
/**
 * The class is responsible for menu changes.
 * author Igor Moskalets
 * Since 10.06.2017
 */
class EditItem extends BaseAction {
	/**
	 * Constructor.
	 * @param name .
	 */
	protected EditItem(String name) {
		super(name);
		}

	/**
	 * key().
	 * @return int.
	 */
	public int key() {
			return 2;
		}

	/**
	 * ececute().
	 * @param input .
	 * @param tracker .
	 */
		public void execute(Input input, Tracker tracker) {
			String nameItemEdit = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(nameItemEdit);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				String name = input.ask("Please, enter the task's new name: ");
				String desc = input.ask("Please, enter the task's new desc: ");
				Item itemEdit = tracker.edit(name, desc, itemFind.getId());
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
	/**
	 * input.
	 */
	private Input input;
	/**
	 * tracker.
	 */
	private Tracker tracker;
	/**
	 * actions.
	 */
	private ArrayList<UserAction> actions = new ArrayList();
	/**
	 * int.
	 */
	private int position = 0;

	/**
	 * Constructor.
	 * @param input .
	 * @param tracker .
	 */
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	/**
	 * fillActions().
	 */
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

	/**
	 * Add action.
	 * @param action .
	 */
	public void addAction(UserAction action) {
		this.actions.add(action);
	}

	/**
	 * select().
	 * @param key .
	 */
	public void select(int key) {
		this.actions.get(key).execute(this.input, this.tracker);
	}

	/**
	 * show().
	 */
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
		/**
		 * Add item.
		 * @param name .
		 */
		private AddItem(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 0;
		}

		/**
		 * execute().
		 * @param input .
		 * @param tracker .
		 */
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			String desc = input.ask("Please, enter the task's desc: ");
			tracker.add(new Item(name, desc));
		}
	}
	/**
	 * Shows all items in the tracker.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
	private static class ShowItems extends BaseAction {
		/**
		 * Show items.
		 * @param name .
		 */
		private ShowItems(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 1;
		}

		/**
		 * execute().
		 * @param input .
		 * @param tracker .
		 */
		public void execute(Input input, Tracker tracker) {
			for (Item item : tracker.getAll()) {
				 if (item != null) {
				 	System.out.println(String.format("%s. %s", item.getId(), item.getName()));
				 }
			}
		}
	}
	/**
	 * Looking for the item name.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
	private class FindItemByName extends BaseAction {
		/**
		 * Find item by name.
		 * @param name .
		 */
		private FindItemByName(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 3;
		}

		/**
		 * execute().
		 * @param input .
		 * @param tracker .
		 */
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(name);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				System.out.println(String.format("%s", itemFind.getName()));
			}
		}
	}
	/**
	 * Looking for the item description.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
	private class FindItemByDesc extends BaseAction {
		/**
		 * Find item by description.
		 * @param name .
		 */
		private FindItemByDesc(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 4;
		}

		/**
		 * execute().
		 * @param input .
		 * @param tracker .
		 */
		public void execute(Input input, Tracker tracker) {
			String desc = input.ask("Please, enter the task's desc: ");
			Item itemFind = tracker.findByDesc(desc);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				System.out.println(String.format("%s", itemFind.getName()));
			}
		}
	}
	/**
	 * Delete a item to the tracker.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
	private class DeleteItem extends BaseAction {
		/**
		 * Delete item.
		 * @param name .
		 */
		private DeleteItem(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 5;
		}

		/**
		 * execute().
		 * @param input .
		 * @param tracker .
		 */
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
		/**
		 * Add comment to item.
		 * @param name .
		 */
		private AddCommentToItem(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 6;
		}

		/**
		 * execute.
		 * @param input .
		 * @param tracker .
		 */
		public void execute(Input input, Tracker tracker) {
			String name = input.ask("Please, enter the task's name: ");
			Item itemFind = tracker.findByName(name);
			if (itemFind == null) {
				System.out.println("Task with the same name does not exist");
			} else {
				String comment = input.ask("Please, enter the comment; ");
				tracker.addComment(name, comment);
			}
		}
	}
	/**
	 * Shows all comments from the selected item.
	 * author Igor Moskalets
	 * Since 10.06.2017
	 */
	private class ShowAllCommentsToItem extends BaseAction {
		/**
		 * Shows all comment item.
		 * @param name .
		 */
		private ShowAllCommentsToItem(String name) {
			super(name);
		}

		/**
		 * key().
		 * @return int.
		 */
		public int key() {
			return 7;
		}

		/**
		 * execute.
		 * @param input .
		 * @param tracker .
		 */
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