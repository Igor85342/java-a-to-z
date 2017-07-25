package ru.moskalets.tracker.start;




import ru.moskalets.tracker.models.*;
import java.util.*;
public class Tracker {
	
	private Item[] items = new Item[10];
	private int position = 0;
	private static final Random RN = new Random();
	
	public int getPosition(){
		return position;
	}
	public Item add(Item item) {
		item.setId(String.valueOf(System.currentTimeMillis() + RN.nextInt()));
		this.items[position++] = item;
		return item;
	}
	
	public void remove(Item item){
		int count = 0;
		Item[] result = new Item[this.items.length - 1];
		for (int index = 0; index < this.items.length; index++) {
			if (items[index] != null & item != null){
				if (!(items[index].id.equals(item.id))) {
					result[index - count] = this.items[index];
				} else {
				count++;
				}
			}	
		} 
		this.items = result;
	}
	
	protected Item findById(String id) {
	
		Item result = null;
		for (Item item: items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
			
		}
		return result;
	}
	
	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int index=0; index!=this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	
	public Item addcomment(String name,String comment) {
		Item result = findByName(name);
		result.setComments(comment);
		
		return result;
	}
	
	
	public Item findByName(String name){
		Item result = null;
		for (Item item: items) {
			if (item != null && item.getName().equals(name)){
				result = item;
				break;
			}
		}
		return result;
	}
	
	public Item findByDesc (String desc){
		Item result = null;
		for (Item item: items) {
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