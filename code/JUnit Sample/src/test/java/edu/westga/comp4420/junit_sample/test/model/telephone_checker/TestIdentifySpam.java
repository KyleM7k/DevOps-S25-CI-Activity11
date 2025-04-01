package edu.westga.comp4420.junit_sample.test.model.telephone_checker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.junit_sample.model.TelephoneChecker;

class TestIdentifySpam {
	
	@ParameterizedTest
	@CsvSource({"9990000000, true", "9000000000, true", "8880000000, true", "8000000000, true", "9110000000, true", "4110000000, true", "4112553200, true", "3033033033, false"})
	void test(long number, boolean expectedResult) {
		TelephoneChecker checker = new TelephoneChecker();
		
		boolean result = checker.identifySpam(number);
		
		assertEquals(expectedResult, result, "checking if number (" + number + ") is from a malicious area code");
	}
	
	@Test
	void testThrow() {
		TelephoneChecker checker = new TelephoneChecker();
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			()->{
				checker.identifySpam(100000000);
			});
			assertEquals("Phone number is not valid.", exception.getMessage());
	}
}
