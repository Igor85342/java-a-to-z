package ru.moskalets.tracker.start;



import org.junit.Assert;
import org.junit.Test;

import ru.moskalets.tracker.models.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTest {
	
	@Test
	public void whenAddTaskShouldCounterIncrement(){
			
			Tracker tracker = new Tracker();
			Task taskTest = new Task("first name", "first desc");
			
			tracker.add(taskTest);
			int cheak = tracker.getPosition();
		
			Assert.assertEquals(1, cheak );
	}
	
	@Test
	public void whenDeleteTaskShouldNotFindsItems(){
		
		Tracker tracker = new Tracker();
		Item taskTest1 = new Item("First name", "First desc",500); 
		Item taskTest2 = new Item("Second name", "Second desc",600);
		Item taskTest3 = new Item("Third name", "Third desc",700);
		tracker.add(taskTest1).setId("100");
		tracker.add(taskTest2).setId("200");
		tracker.add(taskTest3).setId("300");
		
		tracker.remove(taskTest2);
		Item cheak = taskTest2;
		
		for (Item item: tracker.getAll()){
			Assert.assertNotEquals(item, cheak );
		}
		
	}
	
	@Test
	public void whenFindItemShouldReturnThisItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",100); 
		tracker.add(itemTest1).setId("100");
		
		Item cheak = tracker.findById("100");
		
		Assert.assertEquals(itemTest1, cheak);
			
	}
	
	@Test
	public void whenGetAllShouldreturnAllItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500); 
		Item itemTest2 = new Item("Second name", "Second desc",600);
		Item itemTest3 = new Item("Third name", "Third desc",700);
		Item[] items = {itemTest1,itemTest2,itemTest3};
		tracker.add(itemTest1);
		tracker.add(itemTest2);
		tracker.add(itemTest3);
		
		Item[] cheak = tracker.getAll();
		
		Assert.assertEquals(items,cheak);
	}
	
	@Test
	public void whenAddCommentShouldCommentIsPlacedIsArray(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500);
		String[] comment = {"First comment"};
		tracker.add(itemTest1);
		
		tracker.addcomment("First name","First comment");
		String[] cheak = itemTest1.getComments(); 
		
		Assert.assertEquals(comment,cheak);
	}
	
	@Test
	public void whenAddTwoCommentsShouldTwoCommetsIsPlacedIsArray(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500);
		String[] comment = {"First comment","Second comment"};
		tracker.add(itemTest1);
		
		tracker.addcomment("First name","First comment");
		tracker.addcomment("First name","Second comment");
		String[] cheak = itemTest1.getComments(); 
		
		Assert.assertEquals(comment,cheak);
		
	}
	
	@Test
	public void whenFindByNameShouldReturnThisItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500);
		tracker.add(itemTest1);
		
		Item cheak = tracker.findByName("First name");
		
		Assert.assertEquals(itemTest1, cheak);
	}
	
	@Test
	public void whenFindByNameShouldNotReturnThisItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500);
		tracker.add(itemTest1);
		
		Item cheak = tracker.findByName("Second name");
		
		Assert.assertNotEquals(itemTest1, cheak);
		
	}
	
	@Test
	public void whenFindByDescShouldReturnThisItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500);
		tracker.add(itemTest1);
		
		Item cheak = tracker.findByDesc("First desc");
		
		Assert.assertEquals(itemTest1, cheak);
		
	}
	
	@Test
	public void whenFindByDescShouldNotReturnThisItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc",500);
		tracker.add(itemTest1);
		
		Item cheak = tracker.findByDesc("Second desc");
		
		Assert.assertNotEquals(itemTest1, cheak);
		
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