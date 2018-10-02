package ru.moskalets.chapter004.lambda.task002.start;
import org.junit.Assert;
import org.junit.Test;
import ru.moskalets.chapter004.lambda.task002.models.Item;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Testing the class Tracker.
 */
public class TrackerTest {
	/**
	 * firstItem.
	 */
	private final Item firstItem = new Item("first name", "first desc");
	/**
	 * secondItem.
	 */
	private final Item secondItem = new Item("second name", "second desc");
	/**
	 * thirdItem.
	 */
	private final Item thirdItem = new Item("third name", "third desc");

	/**
	 * Test checks the add item.
	 */
	@Test
	public void whenAddItemsReturnList() {
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		List<Item> expected = Arrays.asList(this.firstItem, this.secondItem, this.thirdItem);
		assertThat(tracker.getAll(), is(expected));
	}

	/**
	 * Test verifies deletion of the item.
	 */
	@Test
	public void whenDeleteTaskReturnList() {
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		tracker.remove(this.secondItem);
		List<Item> expected = Arrays.asList(this.firstItem, this.thirdItem);
		assertThat(tracker.getAll(), is(expected));
	}

	/**
	 * This test validates the search by Id.
	 */
	@Test
	public void whenFindItemIdReturnItem() {
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		Item expected = this.secondItem;
		assertThat(tracker.findById(this.secondItem.getId()), is(expected));
	}

	/**
	 * The test checks add a comment.
	 */
	@Test
	public void whenAddCommentReturnItem() {
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		tracker.addComment("second name", "firstComment");
		Item expected = new Item("second name", "second desc", secondItem.getId(), "firstComment");
		assertThat(tracker.findById(secondItem.getId()), is(expected));
	}

	/**
	 * This test validates the search by name.
	 */
	@Test
	public void whenAddNameItemReturnItem() {
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		Item expected = this.secondItem;
		assertThat(tracker.findByName("second name"), is(expected));
	}

	/**
	 * This test validates the search by description.
	 */
	@Test
	public void whenAddDescriptionItemReturnItem() {
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		Item expected = this.secondItem;
		assertThat(tracker.findByDesc("second desc"), is(expected));
	}

	/**
	 * This test validates the replacement of one record to another.
	 */
	@Test
	public void whenSwapTwoItemsShouldReturnValuesSecondItem() {
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc");
		Item itemTest2 = new Item("Second name", "Second desc");
		tracker.add(itemTest1);
		Item cheak = tracker.swap(itemTest1, itemTest2);
		Assert.assertEquals(itemTest1, cheak);
	}
}