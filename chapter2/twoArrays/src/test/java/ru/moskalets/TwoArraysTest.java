package ru.moskalets;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TwoArraysTest{
	
	@Test
	public void whenElementsSecondArrayMaxReturnOneMassive(){
		TwoArrays tA = new TwoArrays();
		int[] first = new int[]{1,2,3,6,9,12};
		int[] second = new int[]{4,5,6,7,15};
		int[] resultTest = new int[]{1,2,3,4,5,6,6,7,9,12,15};
		int[] result = tA.sumTwoArrays(first,second);
		Assert.assertThat(resultTest, is(result));
	}
	
	@Test
	public void whenElementsFirstArrayMaxReturnOneMassive(){
		TwoArrays tA = new TwoArrays();
		int[] first = new int[]{1,2,3,10};
		int[] second = new int[]{3,4,5,6,7};
		int[] resultTest = new int[]{1,2,3,3,4,5,6,7,10};
		int[] result = tA.sumTwoArrays(first,second);
		Assert.assertThat(resultTest, is(result));
	}
}