package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import roman.RomanToNumeralToRoman;

public class TestRomanToNumeralToRoman {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	RomanToNumeralToRoman roman;
	RomanToNumeralToRoman number;
	
	@Before
	public void setUp() {
		roman = new RomanToNumeralToRoman();
		number = new RomanToNumeralToRoman();
	}
	
	@Test
	public void aSingleNumber() {
		assertEquals(1, roman.toNumber("I"));
		assertEquals(5, roman.toNumber("V"));
		assertEquals(10, roman.toNumber("X"));
	}
	
	@Test
	public void aCompoundNumber() {
		assertEquals(2, roman.toNumber("II"));
		assertEquals(6, roman.toNumber("VI"));
	}
	
	@Test
	public void aCompoundNumberWithSubtraction() {
		assertEquals(4, roman.toNumber("IV"));
		assertEquals(9, roman.toNumber("IX"));
		assertEquals(14, roman.toNumber("XIV"));
		assertEquals(19, roman.toNumber("XIX"));
	}
	
	@Test
	public void aVeryLargeNumber() {
		assertEquals(1999, roman.toNumber("MCMXCIX"));
		assertEquals(2015, roman.toNumber("MMXV"));
	}
	
	@Test
	public void numberToSingleRoman() {
		assertEquals("I", number.toRoman(1));
		assertEquals("V", number.toRoman(5));
	}
	
	@Test
	public void numberToMultipleRoman() {
		assertEquals("II", number.toRoman(2));
		assertEquals("III", number.toRoman(3));
	}
	
	@Test
	public void numberToCompoundRoman() {
		assertEquals("XIV", number.toRoman(14));
		assertEquals("XXIX", number.toRoman(29));
	}
	
	@Test
	public void veryLargeNumberToRoman() {
		assertEquals("MCMXCIX", number.toRoman(1999));
		assertEquals("MVCMLXXVI", number.toRoman(4976));
	}
}
