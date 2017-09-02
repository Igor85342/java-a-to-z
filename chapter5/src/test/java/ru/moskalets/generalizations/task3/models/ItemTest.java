package ru.moskalets.generalizations.task3.models;
import org.junit.Assert;
import org.junit.Test;
import ru.moskalets.generalizations.task3.start.Tracker;
/**
 * Testing the class Item.
 * @author Igor Moskalets
 * @since 11.06.2017
 */
public class ItemTest {
	/**
	 * The test checks add comment to the item.
	 */
	@Test
	public void whenAddFirstCommentShouldFieldCommentsInItem() {
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc");
		tracker.add(itemTest1);
		itemTest1.setComments("commentTest");
		Assert.assertNotEquals(null, itemTest1.getComments());
	}

	/**
	 * The test checks add two comments to the item.
	 */
	@Test
	public void whenAddTwoCommentShouldFieldCommentsInItem() {
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc");
		tracker.add(itemTest1);
		String[] testComments = {"First comment", "Second comment"};
		itemTest1.setComments("First comment");
		itemTest1.setComments("Second comment");
		Assert.assertNotEquals(testComments, itemTest1.getComments());
	}
}