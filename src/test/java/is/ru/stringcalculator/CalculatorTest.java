package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test // 1
	public void testEmptyString() throws Exception {
		assertEquals(0, Calculator.add(""));
	}

	@Test // 2
	public void testOneNumber() throws Exception {
		assertEquals(1, Calculator.add("1"));
	}

	@Test // 3
	public void testOneTwoNumbers() throws Exception {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test // 4
    public void testMultipleNumbers() throws Exception {
    	assertEquals(6, Calculator.add("3,2,1"));
    }

	@Test // 5
	public void testOneTwoNumbersNewLine() throws Exception {
		assertEquals(3, Calculator.add("1\n2"));
	}

	@Test // 6
	public void test3Numbers2DifferentDelimiter() throws Exception {
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test // 7 
	public void testNegativeNumbers() throws Exception {
		Calculator.add("-1");
		//assertEquals(3, Calculator.add("1,2"));
	}

	/*@Test
	public void testDifferentDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	} fæ alltaf villu þannig að strengurinn fer ekki inn ráða laus */
}