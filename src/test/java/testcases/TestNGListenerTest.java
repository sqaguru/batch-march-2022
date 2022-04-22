package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGListenerTest {
	@Test
	public void myFailingTest() {
		Assert.assertTrue(false, "Hardcoded for failure of test case");
	}
}
