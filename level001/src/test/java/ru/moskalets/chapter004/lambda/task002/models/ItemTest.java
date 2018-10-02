package ru.moskalets.chapter004.lambda.task002.models;
import org.junit.Assert;
import org.junit.Test;
import ru.moskalets.chapter004.lambda.task002.start.Tracker;
/**
 * Testing the class Item.
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