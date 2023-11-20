package testpackage;

import org.testng.annotations.Test;

public class GroupsTNG {
	@Test(groups = {"smoke testing"})
	public void tc1() {
		System.out.println("Hello!");
	}
	@Test(groups = {"regression testing"})
	public void tc2() {
		System.out.println("Hi!");
	}
	@Test(groups = {"smoke testing"})
	public void tc3() {
		System.out.println("Good Morning!");
	}
	@Test(groups = {"regression testing"})
	public void tc4() {
		System.out.println("Bye!");
	}
}
