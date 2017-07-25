package ru.moskalets.tracker.models;



import org.junit.Assert;
import org.junit.Test;

import ru.moskalets.tracker.start.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
	
	@Test
	public void whenAddFirstCommentShouldFieldCommentsInItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc");
		tracker.add(itemTest1);
		
		
		itemTest1.setComments("commentTest");
		
		Assert.assertNotEquals(null, itemTest1.getComments() );
		
		
	}
	
	@Test
	public void whenAddTwoCommentShouldFieldCommentsInItem(){
		
		Tracker tracker = new Tracker();
		Item itemTest1 = new Item("First name", "First desc");
		tracker.add(itemTest1);
		String[] testComments = {"First comment", "Second comment"};
		
		itemTest1.setComments("First comment");
		itemTest1.setComments("Second comment");
		
		Assert.assertNotEquals(testComments, itemTest1.getComments() );
	}
}