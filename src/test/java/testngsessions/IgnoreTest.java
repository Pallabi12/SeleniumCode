package testngsessions;

import org.testng.annotations.Test;

public class IgnoreTest {

	@Test(description =  "searching a product", priority = 1)
	public void searchTest() {
		System.out.println("Search Test");
	}
	
	@Test(priority = 2)
	public void logoTest() {
		System.out.println("Logo Test");
	}
	
	@Test(enabled = false, description = "making payment via cc or debit card", priority = 3)
	public void paymentTest() {
		System.out.println("Payment Test");
	}
}
