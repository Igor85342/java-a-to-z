package ru.moskalets.generalizations.task3.start;
import org.junit.Assert;
import org.junit.Test;
import ru.moskalets.generalizations.task3.models.*;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Testing the class Tracker.
 * @author Igor Moskalets
 * @since 09.06.2017
 */
public class TrackerTest {
	private final Item firstItem = new Item("first name", "first desc");
	private final Item secondItem = new Item("second name", "second desc");
	private final Item thirdItem = new Item("third name", "third desc");
	@Test
	public void WhenAddItemsReturnList(){
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		List<Item> expected = Arrays.asList(this.firstItem, this.secondItem, this.thirdItem);
		assertThat(tracker.getAll(),is(expected));
	}
	@Test
	public void WhenDeleteTaskReturnList(){
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		tracker.remove(this.secondItem);
		List<Item> expected = Arrays.asList(this.firstItem, this.thirdItem);
		assertThat(tracker.getAll(),is(expected));
	}
	@Test
	public void WhenFindItemIdReturnItem(){
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		Item expected = this.secondItem;
		assertThat(tracker.findById(this.secondItem.getId()),is(expected));
	}
	@Test
	public void WhenAddCommentReturnItem(){
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		tracker.addComment("second name","firstComment");
		Item expected = new Item("second name", "second desc", secondItem.getId(),"firstComment");
		assertThat(tracker.findById(secondItem.getId()),is(expected));
	}
	@Test
	public void WhenAddNameItemReturnItem(){
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		Item expected = this.secondItem;
		assertThat(tracker.findByName("second name"),is(expected));
	}
	@Test
	public void WhenAddDescriptionItemReturnItem(){
		Tracker tracker = new Tracker();
		tracker.add(this.firstItem);
		tracker.add(this.secondItem);
		tracker.add(this.thirdItem);
		Item expected = this.secondItem;
		assertThat(tracker.findByDesc("second desc"),is(expected));
	}
	@Test
	public void whenSwapTwoItemsShouldReturnValuesSecondItem(){
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc");
		Item itemTest2 = new Item("Second name", "Second desc");
		tracker.add(itemTest1);
		Item cheak = tracker.swap(itemTest1,itemTest2);
		Assert.assertEquals(itemTest1, cheak);
	}
}