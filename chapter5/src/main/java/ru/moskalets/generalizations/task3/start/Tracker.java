package ru.moskalets.generalizations.task3.start;
import ru.moskalets.generalizations.task3.models.Item;
import java.util.ArrayList;
import java.util.Random;
/**
 * The main class to operate the tracker. Carries out all operations with items.
 * author Igor Moskalets
 * Since 11.06.2017
 */
public class Tracker {
	/**
	 * items.
	 */
	private ArrayList<Item> items = new ArrayList();
	/**
	 * RN.
	 */
	private static final Random RN = new Random();

	/**
	 * Adds item.
	 * @param item .
	 * @return Item.
	 */
	public Item add(Item item) {
		item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
		this.items.add(item);
		return item;
	}

	/**
	 * Removes item.
	 * @param item .
	 */
	public void remove(Item item) {
		this.items.remove(item);
	}

	/**
	 * Search item by Id.
	 * @param id .
	 * @return Item.
	 */
	public Item findById(String id) {
		Item result = null;
		for (Item item: this.items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	 * Returns all Items.
	 * @return ArrayList<Item>.
	 */
	public ArrayList<Item> getAll() {
		return this.items;
	}

	/**
	 * Add a comment to the item.
	 * @param name .
	 * @param comment .
	 * @return Item.
	 */
	public Item addComment(String name, String comment) {
		Item result = findByName(name);
		result.setComments(comment);
		return result;
	}

	/**
	 * Search item by name.
	 * @param name .
	 * @return Item.
	 */
	public Item findByName(String name) {
		Item result = null;
		for (Item item: this.items) {
			if (item != null && item.getName().equals(name)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	 * Search item by description.
	 * @param desc .
	 * @return Item.
	 */
	public Item findByDesc(String desc) {
		Item result = null;
		for (Item item: this.items) {
			if (item != null && item.getDescription().equals(desc)) {
				result = item;
				break;
			}
		}
		return result;
	}

	/**
	 * The edit item.
	 * @param name .
	 * @param desc .
	 * @param id .
	 * @return Item.
	 */
	public Item edit(String name, String desc, String id) {
		Item result = new Item();
		result.setName(name);
		result.setDesc(desc);
		result.setId(id);
		return result;
	}

	/**
	 * The change item.
	 * @param item .
	 */
	public void update(Item item) {
		for (Item value: items) {
			if (item != null & value != null) {
				if (item.getId().equals(value.getId())) {
					swap(value, item);
				}
			}
		}
	}

	/**
	 * Change of values.
	 * @param value .
	 * @param item .
	 * @return Item.
	 */
	public Item swap(Item value, Item item) {
		if (item != null) {
			value.setName(item.getName());
			value.setDesc(item.getDescription());
			value.setCreate(item.getCreate());
			value.setAllComments(item.getComments());
		}
		return value;
	}
}