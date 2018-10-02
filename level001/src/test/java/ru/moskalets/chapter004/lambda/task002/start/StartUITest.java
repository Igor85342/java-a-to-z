package ru.moskalets.chapter004.lambda.task002.start;
import org.junit.Assert;
import org.junit.Test;
import ru.moskalets.chapter004.lambda.task002.models.Item;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Testing the class StartUITEst.
 * @author Igor Moskalets
 * @since 09.06.2017
 */
public class StartUITest {
	/**
	 * Test checks the add item.
	 */
	@Test
	public void whenCreateTaskReturnTrackerThisAddTask() {
		Input input = new StubInput(new String[] {"First task", "First desc"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		menuTrackerTest.fillActions();
		menuTrackerTest.select(0);
		Assert.assertThat(trackerTest.getAll().get(0).getName(), is("First task"));
		Assert.assertThat(trackerTest.getAll().get(0).getDescription(), is("First desc"));
	}

	/**
	 * This test validates the search by name of item.
	 */
	@Test
	public void whenFindTaskByNameReturnThisTask() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Input input = new StubInput(new String[] {"First task"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		menuTrackerTest.fillActions();
		menuTrackerTest.select(3);
		Assert.assertThat(out.toString(), is("First task\r\n"));
	}

	/**
	 * This test validates the search by description of item.
	 */
	@Test
	public void whenFindTaskByDescriptionReturnThisDescription() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Input input = new StubInput(new String[] {"First desc"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		menuTrackerTest.fillActions();
		menuTrackerTest.select(4);
		Assert.assertThat(out.toString(), is("First task\r\n"));
	}

	/**
	 * Test checks that adding a comment to the item.
	 */
	@Test
	public void whenAddFirstCommentReturnItemWithOneComment() {
		Input input = new StubInput(new String[] {"First task", "First comment"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		menuTrackerTest.fillActions();
		menuTrackerTest.select(6);
		Assert.assertThat(trackerTest.getAll().get(0).getComments().get(0), is("First comment"));
	}

	/**
	 * Test verifies deletion of the item.
	 */
	@Test
	public void whenDeleteItemReturnTrackerWithoutDeletedItem() {
		Input input = new StubInput(new String[] {"First task"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		menuTrackerTest.fillActions();
		menuTrackerTest.select(5);
		assertThat(trackerTest.getAll().size(), is(0));
	}

	/**
	 * This test verifies the change item.
	 */
	@Test
	public void whenEditItemReturnEditedItem() {
		Input input = new StubInput(new String[] {"First task", "First edit task", "First edit desc"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		menuTrackerTest.fillActions();
		menuTrackerTest.select(2);
		Assert.assertThat(trackerTest.getAll().get(0).getName(), is("First edit task"));
		Assert.assertThat(trackerTest.getAll().get(0).getDescription(), is("First edit desc"));
	}
}