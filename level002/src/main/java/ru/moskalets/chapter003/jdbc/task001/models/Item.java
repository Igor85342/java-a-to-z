package ru.moskalets.chapter003.jdbc.task001.models;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * The class implements the item object..
 * author Igor Moskalets
 */
public class Item {
	/**
	 * id.
	 */
	private int id;
	/**
	 * name.
	 */
	private String name;
	/**
	 * description.
	 */
	private String description;
	/**
	 * create.
	 */
	private Timestamp createDate;
	/**
	 * Constructor.
	 */
	public Item() {
	}
	/**
	 * Constructor.
	 * @param name .
	 * @param description .
	 * @param createDate .
	 */
	public Item(String name, String description, Timestamp createDate) {
		this.name = name;
		this.description = description;
		this.createDate = createDate;
	}
	/**
	 * Constructor.
	 * @param name .
	 * @param description .
	 */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	/**
	 * Get name.
	 * @return String.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Get Description.
	 * @return String.
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * Get create.
	 * @return Long.
	 */
	public Timestamp getCreate() {
		return this.createDate;
	}
	/**
	 * Get Id.
	 * @return String.
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Set id.
	 * @param id .
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * setName().
	 * @param name .
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * setDesc().
	 * @param desc .
	 */
	public void setDesc(String desc) {
		this.description = desc;
	}
	/**
	 * setCreate().
	 * @param createDate .
	 */
	public void setCreate(Timestamp createDate) {
		this.createDate = createDate;
	}
}