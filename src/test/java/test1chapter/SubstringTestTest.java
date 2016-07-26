package test1chapter;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SubstringTestTest {
	
		@Test
		public void whenSubstringIsString(){
	
			SubstringTest substringTest = new SubstringTest();
	
			String string = "ladse";
			String substring = "ads";
		
			boolean check = true;
			boolean result = substringTest.contains(string,substring);
			Assert.assertThat(result, is(check));
		}	
		
		@Test
		public void whenSubstringNotIsString(){
	
			SubstringTest substringTest = new SubstringTest();
	
			String string = "ladse";
			String substring = "adc";
		
			boolean check = false;
			boolean result = substringTest.contains(string,substring);
			Assert.assertThat(result, is(check));
		}	
}