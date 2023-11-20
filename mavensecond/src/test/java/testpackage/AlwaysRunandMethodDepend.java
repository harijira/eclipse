package testpackage;

import org.testng.annotations.Test;

import junit.framework.Assert;



public class AlwaysRunandMethodDepend {
	@Test
	public void tc1() {
		System.out.println("hello");
		Assert.fail();
	}
	@Test(alwaysRun = true, dependsOnMethods = "tc1")
	public void tc2() {
		System.out.println("world");
	}
}
