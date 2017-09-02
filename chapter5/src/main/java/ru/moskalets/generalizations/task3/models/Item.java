package ru.moskalets.generalizations.task3.models;
import java.util.ArrayList;
/**
 * The class implements the item object..
 * author Igor Moskalets
 * Since 09.06.2017
 */
public class Item {
	/**
	 * id.
	 */
	private String id;
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
	private long create;
	/**
	 * comments.
	 */
	private ArrayList<String> comments = new ArrayList();

	/**
	 * Constructor.
	 */
	public Item() {
	}

	/**
	 * Constructor.
	 * @param name .
	 * @param description .
	 * @param create .
	 */
	public Item(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
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
	 * Constructor.
	 * @param name .
	 * @param description .
	 * @param id .
	 */
	public Item(String name, String description, String id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}

	/**
	 * Constructor.
	 * @param name .
	 * @param description .
	 * @param id .
	 * @param comment .
	 */
	public Item(String name, String description, String id, String comment) {
		this.name = name;
		this.description = description;
		this.id = id;
		this.comments.add(comment);
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
	public Long getCreate() {
		return this.create;
	}

	/**
	 * Get Id.
	 * @return String.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Set id.
	 * @param id .
	 */
	public void setId(String id) {
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
	 * @param create .
	 */
	public void setCreate(long create) {
		this.create = create;
	}

	/**
	 * getComments().
	 * @return ArrayList<String>.
	 */
	public ArrayList<String> getComments() {
		return this.comments;
	}

	/**
	 * setAllComments().
	 * @param comments .
	 */
	public void setAllComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	/**
	 * Set comments.
	 * @param comment .
	 */
	public void setComments(String comment) {
		this.comments.add(comment);
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		if (create != item.create) {
			return false;
		}
		if (id != null ? !id.equals(item.id) : item.id != null) {
			return false;
		}
		if (name != null ? !name.equals(item.name) : item.name != null) {
			return false;
		}
		if (description != null ? !description.equals(item.description) : item.description != null) {
			return false;
		}
		return comments != null ? comments.equals(item.comments) : item.comments == null;
	}
	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (int) (create ^ (create >>> 32));
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		return result;
	}
}