package ru.moskalets.tracker.start;



import org.junit.Assert;
import org.junit.Test;

import ru.moskalets.tracker.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUITest {
	@Test
	public void whenCreateTaskReturnTrackerThisAddTask(){
		Input input = new StubInput(new String[] {"First task", "First desc"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		
		menuTrackerTest.fillActions();
		menuTrackerTest.select(0);
		
		Assert.assertThat(trackerTest.getAll()[0].getName(),is("First task"));
		Assert.assertThat(trackerTest.getAll()[0].getDescription(),is("First desc"));	
	}
	
	@Test
	public void whenFindTaskByNameReturnThisTask(){
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

	@Test
	public void whenFindTaskByDescriptionReturnThisDescription(){
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
	
	@Test 
	public void whenAddFirstCommentReturnItemWithOneComment(){
		Input input = new StubInput(new String[] {"First task", "First comment"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		
		menuTrackerTest.fillActions();
		menuTrackerTest.select(6);
		
		Assert.assertThat(trackerTest.getAll()[0].getComments()[0], is("First comment"));
	}
	
	@Test
	public void whenDeleteItemReturnTrackerWithoutDeletedItem(){
		Input input = new StubInput(new String[] {"First task"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		
		menuTrackerTest.fillActions();
		menuTrackerTest.select(5);
		
		assertNull(trackerTest.getAll()[0]);
	}
	
	@Test 
	public void whenEditItemReturnEditedItem(){
		Input input = new StubInput(new String[] {"First task", "First edit task", "First edit desc"});
		Tracker trackerTest = new Tracker();
		MenuTracker menuTrackerTest = new MenuTracker(input, trackerTest);
		Item itemTest = new Item("First task", "First desc", 100);
		trackerTest.add(itemTest);
		
		menuTrackerTest.fillActions();
		menuTrackerTest.select(2);
		
		Assert.assertThat(trackerTest.getAll()[0].getName(),is("First edit task"));
		Assert.assertThat(trackerTest.getAll()[0].getDescription(),is("First edit desc"));	
	}
	
}