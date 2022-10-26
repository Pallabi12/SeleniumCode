package testngsessions;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	
	@Test(expectedExceptions = ArithmeticException.class )
	public void searchTest() {
		System.out.println("Search Test");
		int i = 9/0;
	}
}
