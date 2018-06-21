package ru.moskalets.chapter003.jdbc.task001.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.moskalets.chapter003.createupdateinsert.task004.SQLStorage;
import ru.moskalets.chapter003.jdbc.task001.models.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The class is responsible for menu changes.
 * author Igor Moskalets
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
		public void execute(Input input, Tracker tracker) throws SQLException {
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please, enter the task's new name: ");
            String description = input.ask("Please, enter the task's new desc: ");
            tracker.edit(Integer.parseInt(id), name, description);
		}
}

/**
 * The main class menu tracker.
 * author Igor Moskalets
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
		this.actions.add(new CreateTable("Create the table."));
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
	public void select(int key) throws SQLException {
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
	 */
	private class AddItem extends BaseAction {
		private Logger log = LoggerFactory.getLogger(SQLStorage.class);
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
			try {
				tracker.add(new Item(name, desc));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	/**
	 * Shows all items in the tracker.
	 * author Igor Moskalets
	 */
	private static class ShowItems extends BaseAction {
		/**
		 * Show items.
		 * @param name .
		 */
		private static Logger log = LoggerFactory.getLogger(SQLStorage.class);
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
			try {
				tracker.getAll();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	/**
	 * Looking for the item name.
	 * author Igor Moskalets
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
		public void execute(Input input, Tracker tracker) throws SQLException {
			String name = input.ask("Please, enter the task's name: ");
			tracker.findByName(name);
		}
	}
	/**
	 * Looking for the item description.
	 * author Igor Moskalets
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
		public void execute(Input input, Tracker tracker) throws SQLException {
			String desc = input.ask("Please, enter the task's desc: ");
			tracker.findByDesc(desc);
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
		public void execute(Input input, Tracker tracker) throws SQLException {
			String id = input.ask("Please, enter the task's id: ");
			tracker.remove(Integer.parseInt(id));
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
		public void execute(Input input, Tracker tracker) throws SQLException {
			String id = input.ask("Please, enter the task's id: ");
			String comment = input.ask("Please, enter the comment; ");
			tracker.addComment(comment, Integer.parseInt(id));
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
		public void execute(Input input, Tracker tracker) throws SQLException {
			String id = input.ask("Please, enter the task's id: ");
			tracker.showAllCommentsFromItem(Integer.parseInt(id));
		}
	}

	/**
	 * Создает новые таблицы, если выбрано соответствущий пункт меню.
	 */
	private class CreateTable extends BaseAction {
		private Logger log = LoggerFactory.getLogger(SQLStorage.class);
		/**
		 * Конструктор
		 * @param name
		 */
		private CreateTable(String name) {
			super(name);
		}

		/**
		 * Возвращает key
		 * @return
		 */
		public int key() {
			return 8;
		}

		/**
		 * Создает таблицы.
		 * @param input .
		 * @param tracker .
		 */
		public void execute(Input input, Tracker tracker) {
			try {
				tracker.createTable();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			} finally {
				System.out.println("Tables created!");
			}
		}
	}
}