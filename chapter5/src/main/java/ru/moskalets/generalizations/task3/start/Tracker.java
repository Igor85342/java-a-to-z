package ru.moskalets.generalizations.task3.start;
import ru.moskalets.generalizations.task3.models.*;
import java.util.*;
/**
 * The main class to operate the tracker. Carries out all operations with items.
 * author Igor Moskalets
 * Since 11.06.2017
 */
public class Tracker {
	private ArrayList<Item> items = new ArrayList();
	private static final Random RN = new Random();
	public Item add(Item item) {
		item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
		this.items.add(item);
		return item;
	}
	public void remove(Item item){
		this.items.remove(item);
	}
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
	public ArrayList<Item> getAll() {
		return this.items;
	}
	public Item addComment(String name,String comment) {
		Item result = findByName(name);
		result.setComments(comment);
		return result;
	}
	public Item findByName(String name){
		Item result = null;
		for (Item item: this.items) {
			if (item != null && item.getName().equals(name)){
				result = item;
				break;
			}
		}
		return result;
	}
	public Item findByDesc (String desc){
		Item result = null;
		for (Item item: this.items) {
			if (item != null && item.getDescription().equals(desc)){
				result = item;
				break;
			}
		}
		return result;
	}
	public Item edit(String name, String desc, String id) {
		Item result = new Item();
		result.setName(name);
		result.setDesc(desc);
		result.setId(id);
		return result;
	}
	public void update(Item item){
		for (Item value: items){
			if (item != null & value != null){
				if (item.id.equals(value.id)){
					swap(value,item);
				}
			}
		}
	}
	public Item swap(Item value, Item item){
		if (item != null){
			value.setName(item.getName());
			value.setDesc(item.getDescription());
			value.setCreate(item.getCreate());
			value.setAllComments(item.getComments());
		}
		return value;
	}
}