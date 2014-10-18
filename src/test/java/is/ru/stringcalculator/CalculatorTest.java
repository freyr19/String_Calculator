package is.ru.stringcalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class CalculatorTest {
	public static void main(String args[]) {
	org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}
	@Test // 1
	public void testEmptyString()  {
		assertEquals(0, Calculator.add(""));
	}
	@Test // 2
	public void testOneNumber()  {
		assertEquals(1, Calculator.add("1"));
	}
	@Test // 3
	public void testOneTwoNumbers()  {
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test // 4
	public void testMultipleNumbers()  {
		assertEquals(6, Calculator.add("3,2,1"));
	}
	@Test // 5
	public void testOneTwoNumbersNewLine()  {
		//assertEquals(3, Calculator.add("1\n2"));
	}
	@Test // 6
	public void test3Numbers2DifferentDelimiter() {
		//assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Test // 7
	public void testNegativeNumbers()  {
		expectedEx.expectMessage("Negatives not allowed: -1");
		assertEquals(2, Calculator.add("-1,2"));
	}
	@Test // 7
	public void testMultiNegativeNumbers()  {
		expectedEx.expectMessage("Negatives not allowed: -4 -5");
		assertEquals(2, Calculator.add("2,-4,3,-5"));
	}

	@Test // 8
	public void testNumbersBiggerThan1000()  {
		assertEquals(2, Calculator.add("1001,2"));
	}
	@Test
	public void testDifferentDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	} 
}