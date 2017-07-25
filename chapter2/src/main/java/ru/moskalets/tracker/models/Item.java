package ru.moskalets.tracker.models;

public class Item {
	public String id;
	public String name;
	
	public String description;
	
	public long create;
	
	public String[] comments;
	
	public Item () {
		
	}
	
	public Item (String name, String description, long create) {
		this.name = name;
		
		this.description = description;
		
		this.create = create;	
		
	}
	
	public Item (String name, String description) {
		this.name = name;
		
		this.description = description;
		
	}
	
	public Item (String name, String description, String id) {
		this.name = name;
		
		this.description = description;
		
		this.id = id;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Long getCreate() {
		return this.create;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public void setCreate(long create){
			this.create = create;
	}
	
	public String[] getComments() {
		return this.comments;
	}
	
	public void setAllComments(String[] comments){
		this.comments = comments;
	}
	
	
	
	public void setComments(String comment){
		if (this.comments != null) {
			int count = this.comments.length;
			String[] result = new String[count + 1];
			for ( int index = 0; index!=count+1; index++) {
				if (index != count) {
					result[index] = this.comments[index];
				} else {
					result[index] = comment;
				}
			}
			this.comments = result;
		}else {
			String[] result = new String[1];
			result[0] = comment;
			this.comments = result;
		}
		
	}
	
	
	
}