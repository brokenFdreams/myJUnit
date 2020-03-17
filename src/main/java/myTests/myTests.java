package myTests;

import annotations.After;
import annotations.Before;
import annotations.Test;
import calc.Calculator;

import static asserts.MyAsserts.*;

public class myTests {
	private static Calculator calculator;

	@Before
	public void setCalculator() {
		calculator = new Calculator();
	}

	@Test
	public void checkAssertNotNull() {
		assertNotNull(calculator);
	}

	@Test
	public void checkAssertNotNullNull() {
		assertNotNull(null);
	}

	@Test
	public void checkAssertTrueTrue() {
		assertTrue(true);
	}

	@Test
	public void checkAssertTrueFalse() {
		assertTrue(false);
	}

	@Test
	public void checkCorrectSum() {
		assertEquals(3, calculator.calculate("1 + 2"));
		assertEquals(120, calculator.calculate("100 + 20"));
	}

	@Test
	public void checkCorrectDiff() {
		assertEquals(6, calculator.calculate("7 - 1"));
		assertEquals(120, calculator.calculate("178 - 58"));
	}

	@Test
	public void checkCorrectDivision() {
		assertEquals(7, calculator.calculate("7 / 1"));
		assertEquals(512, calculator.calculate("1024 / 2"));
	}

	@Test
	public void checkCorrectReminder() {
		assertEquals(1, calculator.calculate("7 % 2"));
		assertEquals(3, calculator.calculate("133 % 5"));
	}

	@Test
	public void checkInvalidArgument() {
		assertEquals(0, calculator.calculate("1+2"));
		assertEquals(0, calculator.calculate("100+20"));
	}

	@After
	public void checkAfter() {
		System.out.println("Checked annotation After");
	}
}
