package ru.moskalets;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TwoArraysTest - Tests the class TwoArrays.
 * @author Igor Moskalets
 * @since 09.02.2017
 */
public class TwoArraysTest{
	/**
	 * Tests the case where in the second array is a greater element.
	 * Testing method sumTwoArrays.
	 */
	@Test
	public void whenElementsSecondArrayMaxReturnOneMassive(){
		TwoArrays tA = new TwoArrays();
		int[] first = new int[]{1,2,3,6,9,12};
		int[] second = new int[]{4,5,6,7,15};
		int[] resultTest = new int[]{1,2,3,4,5,6,6,7,9,12,15};
		int[] result = tA.sumTwoArrays(first,second);
		Assert.assertThat(resultTest, is(result));
	}

	/**
	 * Tests the case where in the first array is a greater element.
	 * Testing method sumTwoArrays
	 */
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